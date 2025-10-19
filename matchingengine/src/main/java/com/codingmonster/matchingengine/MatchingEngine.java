package com.codingmonster.matchingengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingEngine {

  // instrument id to order book
  // TODO instrument id move from String to u32 for performance
  private final Map<String, OrderBook> books = new HashMap<>();

  List<Result> match(Order order) {
    OrderBook book = books.computeIfAbsent(order.instrumentId, k -> new OrderBook());
    return book.match(order);
  }
}
