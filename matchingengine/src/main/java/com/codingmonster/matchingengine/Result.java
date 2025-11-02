package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.ExecType;
import com.codingmonster.common.sbe.trade.OrdStatus;
import com.codingmonster.common.sbe.trade.Side;

public class Result {
  final long clOrdId; // client order ID
  final String senderCompID;
  final long execId; // unique per execution event
  final Side side;
  final ExecType execType; // FIX ExecType
  final OrdStatus ordStatus; // FIX OrdStatus
  final int lastQty; // filled in this execution
  final int leavesQty; // remaining qty after execution
  final int cumQty; // total filled so far
  final long lastPx; // price of this execution
  final long avgPx; // avg price for cumQty
  final long transactTime; // epoch nanos or FIX UTCTimestamp

  public Result(
      long clOrdId,
      String senderCompID,
      long execId,
      Side side,
      ExecType execType,
      OrdStatus ordStatus,
      int lastQty,
      int leavesQty,
      int cumQty,
      long lastPx,
      long avgPx,
      long transactTime) {
    this.clOrdId = clOrdId;
    this.senderCompID = senderCompID;
    this.execId = execId;
    this.side = side;
    this.execType = execType;
    this.ordStatus = ordStatus;
    this.lastQty = lastQty;
    this.leavesQty = leavesQty;
    this.cumQty = cumQty;
    this.lastPx = lastPx;
    this.avgPx = avgPx;
    this.transactTime = transactTime;
  }

  @Override
  public String toString() {
    return "Result{"
        + "clOrdId="
        + clOrdId
        + ", senderCompID='"
        + senderCompID
        + '\''
        + ", execId="
        + execId
        + ", side="
        + side
        + ", execType="
        + execType
        + ", ordStatus="
        + ordStatus
        + ", lastQty="
        + lastQty
        + ", leavesQty="
        + leavesQty
        + ", cumQty="
        + cumQty
        + ", lastPx="
        + lastPx
        + ", avgPx="
        + avgPx
        + ", transactTime="
        + transactTime
        + '}';
  }
}
