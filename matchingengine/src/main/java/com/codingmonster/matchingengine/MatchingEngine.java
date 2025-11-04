package com.codingmonster.matchingengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingEngine {

  // instrument id to order book
  // instrument id suggested: move from String to u32 for performance
  private final Map<String, OrderBook> books = new HashMap<>();

  List<Result> matchNewOrder(Order order) {
    OrderBook book = books.computeIfAbsent(order.instrumentId, k -> new OrderBook());
    return book.matchNewOrder(order);
  }

  List<Result> modifyOrder(Order order) {
    OrderBook book = books.get(order.instrumentId);
    return book.modifyOrder(order);
  }

  List<Result> cancelOrder(Order order) {
    OrderBook book = books.get(order.instrumentId);
    return book.cancelOrder(order);
  }
}
