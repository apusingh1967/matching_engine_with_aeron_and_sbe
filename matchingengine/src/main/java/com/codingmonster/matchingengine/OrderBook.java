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
  private NavigableMap<Long, LinkedList<Order>> buy;
  // price to list of orders in insertion order FIFO from lowest to highest px
  // use headMap(key, true) to read
  private NavigableMap<Long, LinkedList<Order>> sell;

  public OrderBook() {
    this.buy = new TreeMap<>(Comparator.reverseOrder()); // highest to lowest px
    this.sell = new TreeMap<>(Comparator.naturalOrder()); // lowest to highest px
  }

  List<Result> match(Order order) {
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

  private void matchLimitBuy(Order newOrder, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> multiOrders = this.sell.headMap(newOrder.price, true);
    Iterator<Map.Entry<Long, LinkedList<Order>>> multiOrdersItr = multiOrders.entrySet().iterator();
    int filled = 0;
    int toFill = newOrder.quantity;
    while(multiOrdersItr.hasNext()){
      Map.Entry<Long, LinkedList<Order>> orders = multiOrdersItr.next();
      Iterator<Order> ordersItr = orders.getValue().iterator();
      while(ordersItr.hasNext()){
        Order order = ordersItr.next();
        if((newOrder.quantity - newOrder.filledQuantity) >= (order.quantity - order.filledQuantity)) {
          int qtyRemaining = order.quantity - order.filledQuantity;
          // order from book can be fully filled from new order. order from book can thus be removed
          newOrder.filledQuantity += qtyRemaining;
          order.filledQuantity = qtyRemaining;
          filled += qtyRemaining;
          Result buyerResult = new Result(newOrder.clOrdId, newOrder.senderCompId,
                  (newOrder.orderId << 16) | (2 & 0xFFFF), Side.Buy, ExecType.Fill, OrdStatus.Filled,
          order.filledQuantity, // lastQty: filled in this execution
          newOrder.quantity - newOrder.filledQuantity, // leavesQty: remaining qty after execution
          filled, // total filled so far
          orders.getKey(),
          -1, // will do maybe some other time
          newOrder.timestamp);
          results.add(buyerResult);
          Result sellerResult = new Result(order.clOrdId, order.senderCompId,
                  (newOrder.orderId << 16) | (3 & 0xFFFF), Side.Sell, ExecType.Fill, OrdStatus.Filled,
                  order.quantity - order.filledQuantity, // lastQty: filled in this execution
                  newOrder.quantity - newOrder.filledQuantity, // leavesQty: remaining qty after execution
                  order.filledQuantity, // total filled so far
                  orders.getKey(),
                  -1, // will do maybe some other time
                  newOrder.timestamp);
          results.add(sellerResult);
          ordersItr.remove();
        } else {
          int qtyRemaining = newOrder.quantity - newOrder.filledQuantity;
          // partial fill of last remaining qty in newOrder
          newOrder.filledQuantity = qtyRemaining;
          order.filledQuantity += qtyRemaining;
          filled += qtyRemaining;
          Result buyerResult = new Result(newOrder.clOrdId, newOrder.senderCompId,
                  (newOrder.orderId << 16) | (2 & 0xFFFF), Side.Buy, ExecType.Fill, OrdStatus.Filled,
                  order.filledQuantity, // lastQty: filled in this execution
                  newOrder.quantity - newOrder.filledQuantity, // leavesQty: remaining qty after execution
                  filled, // total filled so far
                  orders.getKey(),
                  -1, // will do maybe some other time
                  newOrder.timestamp);
          results.add(buyerResult);
          Result sellerResult = new Result(order.clOrdId, order.senderCompId,
                  (newOrder.orderId << 16) | (3 & 0xFFFF), Side.Sell, ExecType.Fill, OrdStatus.Filled,
                  order.quantity - order.filledQuantity, // lastQty: filled in this execution
                  newOrder.quantity - newOrder.filledQuantity, // leavesQty: remaining qty after execution
                  order.filledQuantity, // total filled so far
                  orders.getKey(),
                  -1, // will do maybe some other time
                  newOrder.timestamp);
          results.add(sellerResult);
        }
      }
      if(orders.getValue().isEmpty()) {
        multiOrdersItr.remove();
      }
      if(newOrder.filledQuantity < newOrder.quantity) {
        // add limit order to buy side book

      }
    }
  }

  private void matchLimitSell(Order order, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> orders = this.buy.tailMap(order.price, true);
  }

  private void matchMarketBuy(Order order, List<Result> results) {

  }

  private void matchMarketSell(Order order, List<Result> results) {

  }
}
