package com.codingmonster.matchingengine;

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
    return null;
  }
}
