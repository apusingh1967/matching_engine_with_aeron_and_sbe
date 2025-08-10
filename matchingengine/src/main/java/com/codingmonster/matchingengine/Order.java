package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.Side;

class Order {
  long orderId;
  long price; // In integer ticks (e.g., 123456 for $1234.56)
  int quantity;
  Side side;
  long timestamp; // For FIFO

  public Order(long orderId, long price, int quantity, Side side, long timestamp) {
    this.orderId = orderId;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
    this.timestamp = timestamp;
  }
}
