package com.codingmonster.matchingengine;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.TreeMap;

public class OrderBook {

  // Java Map and LinkedList not cache friendly at all
  // TODO replace with Agrona off heap structures in future
  private NavigableMap<Long, LinkedList<Order>> buy;
  private NavigableMap<Long, LinkedList<Order>> sell;

  public OrderBook() {
    this.buy = new TreeMap<>(Comparator.reverseOrder());
    this.sell = new TreeMap<>(Comparator.naturalOrder());
  }

  Result match(Order order) {
    return null;
  }
}
