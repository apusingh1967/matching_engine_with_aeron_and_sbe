package com.codingmonster.client;

import com.codingmonster.common.sbe.trade.MessageHeaderEncoder;
import com.codingmonster.common.sbe.trade.NewOrderSingleEncoder;
import com.codingmonster.common.sbe.trade.Side;
import io.aeron.Aeron;
import io.aeron.Publication;
import java.nio.ByteBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.junit.jupiter.api.Test;

public class ClientTests {
  @Test
  public void given_sell_and_matched_buy_then_filled_er() {
    Aeron.Context ctx =
        new Aeron.Context()
            .aeronDirectoryName("/tmp/aeron"); // match the name with server process if using IPC
    try (Aeron aeron = Aeron.connect(ctx)) {
      Publication publication = aeron.addPublication("aeron:ipc", 10);
      // "aeron:udp?endpoint=localhost:40123"

      // Prepare a direct buffer to write the message into
      UnsafeBuffer buffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));

      // Create and wrap the header and message encoder
      MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
      NewOrderSingleEncoder orderEncoder = new NewOrderSingleEncoder();

      // Start writing from offset 0
      int offset = 0;

      orderEncoder
          .wrapAndApplyHeader(buffer, offset, headerEncoder)
          .clOrdID(12345)
          .side(Side.Buy) // e.g., Buy
          .orderQty(100);
      orderEncoder.price().exponent((byte) 5).mantissa(22345);

      int length = MessageHeaderEncoder.ENCODED_LENGTH + orderEncoder.encodedLength();

      // Send the message over Aeron
      long result = publication.offer(buffer, offset, length);
      if (result < 0) {
        System.err.println("Offer failed: " + result);
      }
    }
  }
}
