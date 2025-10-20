package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.OrderType;
import com.codingmonster.common.sbe.trade.Side;

import java.util.*;

public class OrderBook {

  // Java Map and LinkedList not cache friendly at all, highly inefficient
  // TODO replace with Agrona off heap structures in future

  // price to list of orders in insertion order FIFO from highest to lowest px
  private NavigableMap<Long, LinkedList<Order>> buy;
  // price to list of orders in insertion order FIFO from lowest to highest px
  private NavigableMap<Long, LinkedList<Order>> sell;

  public OrderBook() {
    this.buy = new TreeMap<>(Comparator.reverseOrder()); // highest to lowest px
    this.sell = new TreeMap<>(Comparator.naturalOrder()); // lowest to highest px
  }

  List<Result> match(Order order) {
    List<Result> results = new ArrayList<>();

    switch (order.orderType) {
      case Limit -> {
        if (order.side == Side.Buy) {
          matchLimitBuy(order, results);
        } else if (order.side == Side.Sell) {
          matchLimitSell(order, results);
        } else {
          throw new IllegalArgumentException("Invalid side: " + order.side);
        }
      }
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

  }

  private void matchLimitSell(Order order, List<Result> results) {

  }

  private void matchMarketBuy(Order order, List<Result> results) {

  }

  private void matchMarketSell(Order order, List<Result> results) {

  }


}
