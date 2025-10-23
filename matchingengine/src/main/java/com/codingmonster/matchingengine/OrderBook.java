package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.OrderType;
import com.codingmonster.common.sbe.trade.Side;

import java.util.*;

public class OrderBook {

  // Java Map and LinkedList not cache friendly at all, highly inefficient
  // TODO replace with Agrona off heap structures in future

  // price to list of orders in insertion order FIFO from highest to lowest px
  // use tailMap(key, tru) to read
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

  private void matchLimitBuy(Order order, List<Result> results) {
    NavigableMap<Long, LinkedList<Order>> orders = this.sell.tailMap(order.price, true);

  }

  private void matchLimitSell(Order order, List<Result> results) {

  }

  private void matchMarketBuy(Order order, List<Result> results) {

  }

  private void matchMarketSell(Order order, List<Result> results) {

  }


}
