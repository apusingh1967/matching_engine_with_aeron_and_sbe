package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.Side;

class Order {
  public final long orderId; // Exchange-generated unique ID
  public final long clOrdId; // Client-provided ID
  public final String instrumentId; // Numeric ID for symbol (for fast lookup)
  public final long price; // Integer ticks (e.g. 123456 = $1234.56)
  public final int quantity; // Original order quantity
  public int filledQuantity; // Updated as matches happen
  public final Side side; // Buy or Sell
  public final long timestamp; // Entry time (ns)

  public Order(
      long orderId,
      long clOrdId,
      String instrumentId,
      long price,
      int quantity,
      Side side,
      long timestamp) {
    this.orderId = orderId;
    this.clOrdId = clOrdId;
    this.instrumentId = instrumentId;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
    this.timestamp = timestamp;
  }
}
