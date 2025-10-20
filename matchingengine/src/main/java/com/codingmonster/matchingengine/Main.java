package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.admin.StopSessionDecoder;
import com.codingmonster.common.sbe.trade.*;
import com.codingmonster.common.sbe.trade.OrderType;
import io.aeron.Aeron;
import io.aeron.FragmentAssembler;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.BackoffIdleStrategy;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  private static CountDownLatch latch;

  // none of these following fields is thread safe
  // but we are going single thread, and plan to scale using thread per shard of instruments

  private final MatchingEngine matchingEngine;
  private final OrderIdGenerator orderIdGenerator;

  // Single subscription to channel where all trade requests received
  private final Subscription subscription;

  // one publication per client/trader which is key of map
  private final Map<String, Publication> publications = new HashMap<>();

  // reusable publish off heap buffer
  private final UnsafeBuffer publishBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(4096));
  private final MessageHeaderEncoder messageHeaderEncoder = new MessageHeaderEncoder();
  private final MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
  private final NewOrderSingleDecoder newOrderSingleDecoder = new NewOrderSingleDecoder();
  private final OrderCancelReplaceRequestDecoder orderCancelReplaceRequestDecoder =
      new OrderCancelReplaceRequestDecoder();
  private final OrderCancelRequestDecoder orderCancelRequestDecoder =
      new OrderCancelRequestDecoder();
  private final ExecutionReportEncoder executionReportEncoder = new ExecutionReportEncoder();

  // This uses BackoffIdleStrategy, which is a progressive idle strategy that escalates from busy
  // spinning → yielding → parking (sleeping).
  // In dedicated single thread, just use busy spin. It will ensure cpu core is occupied.
  // The rest here is just for demonstrating other parameters.
  //
  // The constructor parameters mean:
  // spins = 100
  //   First, the thread will busy-spin in a loop for up to 100 iterations (fastest, lowest latency,
  // but burns CPU).
  // yields = 10
  //   If still idle, the thread will call Thread.yield() up to 10 times (lets the OS scheduler run
  // other threads).
  // minParkPeriodNs = 1 microsecond
  //   After spins and yields, the thread will LockSupport.parkNanos() for a small time (here: 1
  // µs).
  // maxParkPeriodNs = 1 millisecond
  //   If it remains idle for longer, the park time backs off exponentially up to 1 ms max.
  private final IdleStrategy idleStrategy =
      new BackoffIdleStrategy(
          100, 10, TimeUnit.MICROSECONDS.toNanos(1), TimeUnit.MILLISECONDS.toNanos(1));

  public static void main(String[] args) {
    latch = new CountDownLatch(1); // only one thread so far

    // try (MediaDriver ignore = MediaDriver.launchEmbedded(context)) {
    //    for (int i = 0; i < 1; i++) {
          final int core = 0;
    // CPU affinity with core. In hyperthreading, will try to affinity one thread per
    // core, and when all used, then move to use hyperthreaded twin
    // does not work on ARM, uncomment on x64 for thread affinity
    // try (AffinityLock lock = AffinityLock.acquireLock(core)) {
    //  }
    Thread t = new Thread(() -> new Main(core));
    t.setDaemon(true);
    t.start();
    //    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    //  }
  }

  public Main(int core) {
    this.matchingEngine = new MatchingEngine();
    this.orderIdGenerator = new OrderIdGenerator(core);
    // not thread safe, create in each thread
    MediaDriver.Context context =
        new MediaDriver.Context()
            .aeronDirectoryName(
                System.getProperty("user.home") + "/aeron"); // .dirDeleteOnStart(true);

    Aeron.Context aeronCtx = new Aeron.Context().aeronDirectoryName(context.aeronDirectoryName());

    try (Aeron aeron = Aeron.connect(aeronCtx)) {
      Subscription subscription = aeron.addSubscription("aeron:ipc", 10);
      LOG.info("Subscribed to: " + subscription.toString());
      this.subscription = subscription;

      // two traders/clients setup so far
      this.publications.put("trader1", aeron.addPublication("aeron:ipc", 11));
      this.publications.put("trader2", aeron.addPublication("aeron:ipc", 12));
      LOG.info(String.format("Matching Engine Instance Ready for traders: %s", this.publications));

      runEventLoop();
    }
  }

  private void runEventLoop() {
    while (latch.getCount() > 0) {
      // there is a more primitive alternative called FragmentHandler which handles one MTU only
      // but FragmentAssembler assembles all MTU of same message into single call
      //
      // buffer → internal receive buffer
      // offset → where your SBE message starts in receive buffer
      // length → total message size (you rarely need it)
      // header → Aeron transport header, not your SBE header
      //      Aeron internal buffer
      // ┌──────────────────────────────┬───────────────────────────┬──────────────┐
      // │  (Aeron transport framing)   │  SBE Message Header       │ Message Body │
      // │  (not visible to you here)   │ blockLen, templateId, ... │ your fields  │
      // └──────────────────────────────┴───────────────────────────┴──────────────┘
      //                              ^ offset passed to you

      FragmentAssembler assembler =
          new FragmentAssembler(
              (buffer, offset, length, header) -> {
                messageHeaderDecoder.wrap(buffer, offset);
                int templateId = messageHeaderDecoder.templateId();
                switch (templateId) {
                  case NewOrderSingleDecoder.TEMPLATE_ID:
                    processNewOrderSingle(buffer, offset, messageHeaderDecoder);
                    break;
                  case OrderCancelReplaceRequestDecoder.TEMPLATE_ID:
                    // TODO order modify
                    break;
                  case OrderCancelRequestDecoder.TEMPLATE_ID:
                    // TODO order cancel
                    break;
                  case StopSessionDecoder.TEMPLATE_ID:
                    // admin message to shutdown ME
                    latch.countDown();
                    break;
                  default:
                    LOG.error("Unknown message with templateId: " + templateId);
                }
              });

      // Poll from the subscription
      // result can be zero if no message available
      int fragmentsRead;
      do {
        // fragmentLimit is tunable
        // - Low for latency
        // - High for throughput
        fragmentsRead = subscription.poll(assembler, 1);
        if (fragmentsRead == 0) {
          idleStrategy.idle();
        }
      } while (fragmentsRead == 0);
    }
  }

  private void processNewOrderSingle(
      DirectBuffer buffer, int offset, MessageHeaderDecoder headerDecoder) {
    newOrderSingleDecoder.wrapAndApplyHeader(buffer, offset, headerDecoder);

    var senderCompID = newOrderSingleDecoder.senderCompID();
    long clOrdID = newOrderSingleDecoder.clOrdID();
    Side side =
        newOrderSingleDecoder.side();
    int qty = newOrderSingleDecoder.orderQty();
    PriceDecoder price = newOrderSingleDecoder.price();
    long timestamp = newOrderSingleDecoder.timestamp();
    LOG.info(
        "Received order: sender={}, ID={}, Side={}, Qty={}, Price={}, TS: {}",
        senderCompID,
        clOrdID,
        side,
        qty,
        price,
        timestamp);

    if (newOrderSingleDecoder.orderType().equals(OrderType.Limit)
            || (newOrderSingleDecoder.orderType().equals(OrderType.Market))) {
      Order order = new Order(this.orderIdGenerator.nextId(), newOrderSingleDecoder.clOrdID(), newOrderSingleDecoder.symbol(),
              newOrderSingleDecoder.price().mantissa(), newOrderSingleDecoder.orderQty(), newOrderSingleDecoder.side(),
              newOrderSingleDecoder.orderType(), newOrderSingleDecoder.timestamp());
      List<Result>results = matchingEngine.match(order);
      for(Result result: results) {
        sendExecutionReport(result);
      }
    } else {
      LOG.warn("Order type not supported: " + newOrderSingleDecoder.orderType());
    }
  }

  private void sendExecutionReport(Result result) {
    // 1. Wrap a buffer at offset 0 for header + message
    // for single message, offset = 0 is good enough
    // for multiple, offset needs to be updated with message length
    int offset = 0;
    // 2. No need to populate header, it is auto done in wrapandapplyheader
    // 3. Encode your ExecutionReport payload right after header
    executionReportEncoder.wrapAndApplyHeader(this.publishBuffer, offset, messageHeaderEncoder);
    executionReportEncoder
        .clOrdID(result.clOrdId)
        .execType(result.execType)
        .ordStatus(result.ordStatus)
        .filledQty(result.cumQty)
        .leavesQty(result.leavesQty);
    executionReportEncoder.senderCompID().appendTo(new StringBuilder(result.senderCompID));
    executionReportEncoder.price().exponent((byte) -2).mantissa(result.lastPx);

    // 4. Calculate total length = header + payload
    //    Unlike something like ByteBuffer.flip() in NIO, Aeron doesn’t know how much of your buffer
    // you used
    //    because you’re using SBE, which encodes data into a raw buffer independently.
    //    So unless you track how much data was written, Aeron has no clue what your message
    // boundaries are.
    //    That’s why you calculate the exact length manually.
    int length = messageHeaderEncoder.encodedLength() + executionReportEncoder.encodedLength();

    Publication publication = publications.get(result.senderCompID);
    // 5. Send via Aeron
    long newStreamPosition;
    do {
      newStreamPosition = publication.offer(this.publishBuffer, offset, length);
      if (newStreamPosition < 0) {
        if (newStreamPosition == Publication.BACK_PRESSURED) {
          LOG.warn("Back pressured");
        } else if (newStreamPosition == Publication.NOT_CONNECTED) {
          LOG.warn("Not connected");
        } else if (newStreamPosition == Publication.ADMIN_ACTION) {
          LOG.warn("Admin action");
        } else {
          LOG.warn("Unknown error " + newStreamPosition);
        }
      } else {
        LOG.info("Message sent at position " + newStreamPosition);
      }
    } while (newStreamPosition <= 0);
  }
}
