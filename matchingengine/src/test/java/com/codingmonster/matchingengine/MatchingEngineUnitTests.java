package com.codingmonster.matchingengine;

import java.util.*;

import com.codingmonster.common.sbe.trade.OrderType;
import com.codingmonster.common.sbe.trade.Side;
import org.junit.jupiter.api.Test;

public class MatchingEngineUnitTests {

  @Test
  public void testme() {
    MatchingEngine me = new MatchingEngine();
    List<Result> results = me.match(new Order(123, 1233, "trader1", "AAPL", 1234, 10, Side.Sell, OrderType.Limit, 100000));
    for(Result r: results) {
      System.out.println(r);
    }
    System.out.println("**********************");
    results = me.match(new Order(124, 1234, "trader2", "AAPL", 1234, 10, Side.Buy, OrderType.Market, 100000));
    for(Result r: results) {
      System.out.println(r);
    }
  }
}
