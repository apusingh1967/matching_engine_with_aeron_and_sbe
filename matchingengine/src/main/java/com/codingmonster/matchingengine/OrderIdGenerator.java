package com.codingmonster.matchingengine;

import java.util.concurrent.atomic.AtomicInteger;

// sortable and cluster wide unique order id
public class OrderIdGenerator {
  private final int shardId;
  private final AtomicInteger sequence = new AtomicInteger();

  public OrderIdGenerator(int shardId) {
    this.shardId = shardId;
  }

  public long nextId() {
    long timePart = (System.currentTimeMillis() & ((1L << 42) - 1)) << (10 + 12);
    long shardPart = ((long) shardId & 0x3FF) << 12;
    long seqPart = sequence.getAndIncrement() & 0xFFF;
    return timePart | shardPart | seqPart;
  }
}
