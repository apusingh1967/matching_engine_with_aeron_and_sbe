package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.ExecType;
import com.codingmonster.common.sbe.trade.OrdStatus;

public class Result {
  final int clOrdId; // client order ID
  final String execId; // unique per execution event
  final ExecType execType; // FIX ExecType
  final OrdStatus ordStatus; // FIX OrdStatus
  final int lastQty; // filled in this execution
  final int leavesQty; // remaining qty after execution
  final int cumQty; // total filled so far
  final long lastPx; // price of this execution
  final long avgPx; // avg price for cumQty
  final long transactTime; // epoch nanos or FIX UTCTimestamp

  public Result(
      int clOrdId,
      String execId,
      ExecType execType,
      OrdStatus ordStatus,
      int lastQty,
      int leavesQty,
      int cumQty,
      long lastPx,
      long avgPx,
      long transactTime) {
    this.clOrdId = clOrdId;
    this.execId = execId;
    this.execType = execType;
    this.ordStatus = ordStatus;
    this.lastQty = lastQty;
    this.leavesQty = leavesQty;
    this.cumQty = cumQty;
    this.lastPx = lastPx;
    this.avgPx = avgPx;
    this.transactTime = transactTime;
  }
}
