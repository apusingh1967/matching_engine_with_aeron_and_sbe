package com.codingmonster.matchingengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingEngine {

  // instrument id to order book
  private final Map<String, OrderBook> books = new HashMap<>();

  List<Result> match(Order order) {
    OrderBook book = books.get(order.instrumentId);
    return book.match(order);
  }
}
