package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.ExecType;
import com.codingmonster.common.sbe.trade.OrdStatus;
import com.codingmonster.common.sbe.trade.OrderType;
import com.codingmonster.common.sbe.trade.Side;
import java.util.*;

public class OrderBook {

  // Java Map and LinkedList not cache friendly at all, highly inefficient
  // TODO replace with Agrona off heap structures in future

  // price to list of orders in insertion order FIFO from highest to lowest px
  // use tailMap(key, true) to read
  private final NavigableMap<Long, LinkedList<Order>> buy;
  // price to list of orders in insertion order FIFO from lowest to highest px
  // use headMap(key, true) to read
  private final NavigableMap<Long, LinkedList<Order>> sell;

  public OrderBook() {
    this.buy = new TreeMap<>(Comparator.reverseOrder()); // highest to lowest px
    this.sell = new TreeMap<>(Comparator.naturalOrder()); // lowest to highest px
  }

  List<Result> matchNewOrder(Order order) {
    List<Result> results = new ArrayList<>();

    switch (order.orderType) {
        // limit order has price, which could be:
        // - limit buy above lowest price in sell
        // - limit sell below highest price in buy
        // in these cases, try to fill orders immediately which match
        // and the remainder become a limit order
      case Limit -> {
        if (order.side == Side.Buy) {
          matchLimitBuy(order, results);
        } else if (order.side == Side.Sell) {
          matchLimitSell(order, results);
        } else {
          throw new IllegalArgumentException("Invalid side: " + order.side);
        }
      }
        // for market orders, ignore price
        // match immediately, will never rest
        // unfulfilled quantity will send back exec report as cancelled
      case Market -> {
        if (order.side == Side.Buy) {
          matchMarketBuy(order, results);
        } else if (order.side == Side.Sell) {
          matchMarketSell(order, results);
        } else {
          throw new IllegalArgumentException("Invalid side: " + order.side);
        }
      }
      default -> throw new IllegalArgumentException("Invalid order type: " + order.orderType);
    }
    return results;
  }

  private void matchLimitBuy(Order incomingOrder, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> multiOrders =
        this.sell.headMap(incomingOrder.price, true);
    match(incomingOrder, results, multiOrders, Side.Buy);
  }

  private void matchLimitSell(Order incomingOrder, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> multiOrders = this.buy.tailMap(incomingOrder.price, true);
    match(incomingOrder, results, multiOrders, Side.Sell);
  }

  private void matchMarketBuy(Order incomingOrder, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> multiOrders =
        this.sell.headMap(incomingOrder.price, true);
    match(incomingOrder, results, multiOrders, Side.Buy);
  }

  private void matchMarketSell(Order incomingOrder, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> multiOrders = this.buy.tailMap(incomingOrder.price, true);
    match(incomingOrder, results, multiOrders, Side.Sell);
  }

  private void match(
      Order incomingOrder,
      List<Result> results,
      NavigableMap<Long, LinkedList<Order>> multiOrders,
      Side side) {
    Iterator<Map.Entry<Long, LinkedList<Order>>> multiOrdersItr = multiOrders.entrySet().iterator();
    int filled = 0;
    while (multiOrdersItr.hasNext()) {
      Map.Entry<Long, LinkedList<Order>> orders = multiOrdersItr.next();
      Iterator<Order> ordersItr = orders.getValue().iterator();
      while (ordersItr.hasNext()) {
        Order order = ordersItr.next();
        if (order.senderCompId.equals(incomingOrder.senderCompId)) {
          return;
        }
        int qtyTransact =
            Math.min(
                (incomingOrder.quantity - incomingOrder.filledQuantity),
                (order.quantity - order.filledQuantity));
        // order from book can be fully filled from new order. order from book can thus be removed
        incomingOrder.filledQuantity += qtyTransact;
        order.filledQuantity += qtyTransact;
        filled += qtyTransact;
        Result incomingOrderResult =
            new Result(
                incomingOrder.clOrdId,
                incomingOrder.senderCompId,
                (incomingOrder.orderId << 16) | (2 & 0xFFFF),
                side,
                ExecType.Fill,
                OrdStatus.Filled,
                order.filledQuantity, // lastQty: filled in this execution
                incomingOrder.quantity
                    - incomingOrder.filledQuantity, // leavesQty: remaining qty after execution
                filled, // total filled so far
                orders.getKey(),
                -1, // will do maybe some other time
                incomingOrder.timestamp);
        results.add(incomingOrderResult);
        ExecType restingOrderExecType = ExecType.Fill;
        OrdStatus restingOrderOrdStatus = OrdStatus.Filled;
        if (order.filledQuantity < order.quantity) {
          restingOrderExecType = ExecType.PartialFill;
          restingOrderOrdStatus = OrdStatus.PartiallyFilled;
        }
        Result restingOrderResult =
            new Result(
                order.clOrdId,
                order.senderCompId,
                (incomingOrder.orderId << 16) | (4 & 0xFFFF),
                side == Side.Buy ? Side.Sell : Side.Buy,
                restingOrderExecType,
                restingOrderOrdStatus,
                order.quantity - order.filledQuantity, // lastQty: filled in this execution
                incomingOrder.quantity
                    - incomingOrder.filledQuantity, // leavesQty: remaining qty after execution
                order.filledQuantity, // total filled so far
                orders.getKey(),
                -1, // will do maybe some other time
                incomingOrder.timestamp);
        results.add(restingOrderResult);
        ordersItr.remove();
      }
      if (orders.getValue().isEmpty()) {
        multiOrdersItr.remove();
      }
    }
    if (incomingOrder.filledQuantity < incomingOrder.quantity) {
      if (incomingOrder.orderType == OrderType.Limit) {
        // add limit order with remaining qty to book
        if (side == Side.Buy) {
          this.buy.putIfAbsent(incomingOrder.price, new LinkedList<>());
          this.buy.get(incomingOrder.price).add(incomingOrder);
        } else if (side == Side.Sell) {
          this.sell.putIfAbsent(incomingOrder.price, new LinkedList<>());
          this.sell.get(incomingOrder.price).add(incomingOrder);
        }
      } else if (incomingOrder.orderType == OrderType.Market) {
        Result incomingOrderResult =
            new Result(
                incomingOrder.clOrdId,
                incomingOrder.senderCompId,
                (incomingOrder.orderId << 16) | (2 & 0xFFFF),
                side,
                ExecType.PartialFill,
                OrdStatus.PartiallyFilled,
                incomingOrder.filledQuantity, // lastQty: filled in this execution
                incomingOrder.quantity
                    - incomingOrder.filledQuantity, // leavesQty: remaining qty after execution
                filled, // total filled so far
                incomingOrder.price,
                -1, // will do maybe some other time
                incomingOrder.timestamp);
        results.add(incomingOrderResult);
      }
    }
  }

  List<Result> modifyOrder(Order incomingOrder) {
    List<Result> results = new ArrayList<>();
    modifyOrder(incomingOrder, this.buy, results);
    modifyOrder(incomingOrder, this.sell, results);
    return results;
  }

  private static void modifyOrder(
      Order incomingOrder,
      NavigableMap<Long, LinkedList<Order>> orderOrders,
      List<Result> results) {
    Iterator<Map.Entry<Long, LinkedList<Order>>> multiOrdersItr = orderOrders.entrySet().iterator();
    while (multiOrdersItr.hasNext()) {
      Map.Entry<Long, LinkedList<Order>> entry = multiOrdersItr.next();
      Iterator<Order> ordersItr = entry.getValue().iterator();
      while (ordersItr.hasNext()) {
        Order order = ordersItr.next();
        if (order.clOrdId == incomingOrder.clOrdId) {
          order.quantity = incomingOrder.quantity;
          Result result =
              new Result(
                  incomingOrder.clOrdId,
                  incomingOrder.senderCompId,
                  (incomingOrder.orderId << 16) | (2 & 0xFFFF),
                  Side.NULL_VAL,
                  ExecType.NULL_VAL, // should be modify or something
                  OrdStatus.NULL_VAL, // should be modify?
                  order.filledQuantity, // lastQty: filled in this execution
                  incomingOrder.quantity
                      - incomingOrder.filledQuantity, // leavesQty: remaining qty after execution
                  order.filledQuantity, // total filled so far
                  order.price,
                  -1, // will do maybe some other time
                  incomingOrder.timestamp);
          results.add(result);
          break;
        }
      }
    }
  }

  List<Result> cancelOrder(Order order) {
    List<Result> results = new ArrayList<>();
    cancelOrder(order, this.buy, results);
    cancelOrder(order, this.sell, results);
    return results;
  }

  private void cancelOrder(
      Order incomingOrder,
      NavigableMap<Long, LinkedList<Order>> orderOrders,
      List<Result> results) {
    // TODO improve performance
    Iterator<Map.Entry<Long, LinkedList<Order>>> multiOrdersItr = orderOrders.entrySet().iterator();
    while (multiOrdersItr.hasNext()) {
      Map.Entry<Long, LinkedList<Order>> entry = multiOrdersItr.next();
      Iterator<Order> ordersItr = entry.getValue().iterator();
      while (ordersItr.hasNext()) {
        Order o = ordersItr.next();
        if (o.clOrdId == incomingOrder.clOrdId) {
          ordersItr.remove();
          Result result =
              new Result(
                  incomingOrder.clOrdId,
                  incomingOrder.senderCompId,
                  (incomingOrder.orderId << 16) | (2 & 0xFFFF),
                  Side.NULL_VAL,
                  ExecType.NULL_VAL, // should be cancel?
                  OrdStatus.Canceled,
                  incomingOrder.filledQuantity, // lastQty: filled in this execution
                  incomingOrder.quantity
                      - incomingOrder.filledQuantity, // leavesQty: remaining qty after execution
                  incomingOrder.filledQuantity, // total filled so far
                  incomingOrder.price,
                  -1, // will do maybe some other time
                  incomingOrder.timestamp);
          results.add(result);
          break;
        }
      }
    }
  }
}
