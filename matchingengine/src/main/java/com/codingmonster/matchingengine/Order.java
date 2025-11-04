package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.OrderType;
import com.codingmonster.common.sbe.trade.Side;

class Order {
  public final long orderId; // Exchange-generated unique ID
  public final long clOrdId; // Client-provided ID
  public final String senderCompId;
  public final String instrumentId; // Numeric ID for symbol (for fast lookup)
  public final long price; // Integer ticks (e.g. 123456 = $1234.56)
  public int quantity; // Original order quantity
  public int filledQuantity; // Updated as matches happen
  public final Side side; // Buy or Sell
  public final OrderType orderType; // limit or market
  public final long timestamp; // Entry time (ns)

  public Order(
      long orderId,
      long clOrdId,
      String senderCompId,
      String instrumentId,
      long price,
      int quantity,
      Side side,
      OrderType orderType,
      long timestamp) {
    this.orderId = orderId;
    this.clOrdId = clOrdId;
    this.senderCompId = senderCompId;
    this.instrumentId = instrumentId;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
    this.orderType = orderType;
    this.timestamp = timestamp;
  }
}
