package com.codingmonster.matchingengine;

import com.codingmonster.common.sbe.trade.MessageHeaderDecoder;
import com.codingmonster.common.sbe.trade.NewOrderSingleDecoder;
import com.codingmonster.common.sbe.trade.PriceDecoder;
import com.codingmonster.common.sbe.trade.Side;
import io.aeron.Aeron;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import io.aeron.logbuffer.FragmentHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

  public static void main(String[] args) {
    new Main().start();
  }

  private AtomicBoolean started = new AtomicBoolean(true);

  private void start() {
    MediaDriver.Context context =
        new MediaDriver.Context()
            .aeronDirectoryName("/tmp/aeron") // 👈 Set custom directory
            .dirDeleteOnStart(true); // Optional: clean dir on start

    MediaDriver mediaDriver = MediaDriver.launchEmbedded(context);

    Aeron.Context aeronCtx = new Aeron.Context().aeronDirectoryName(context.aeronDirectoryName());
    try (Aeron aeron = Aeron.connect(aeronCtx)) {
      Subscription subscription = aeron.addSubscription("aeron:ipc", 10);
      // "aeron:udp?endpoint=localhost:40123"

      while (started.get()) {
        FragmentHandler handler =
            (buffer, offset, length, header) -> {
              // Decode header
              MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
              headerDecoder.wrap(buffer, offset);

              int templateId = headerDecoder.templateId();
              if (templateId == NewOrderSingleDecoder.TEMPLATE_ID) {
                // Decode message
                NewOrderSingleDecoder orderDecoder = new NewOrderSingleDecoder();
                orderDecoder.wrap(
                    buffer,
                    offset + MessageHeaderDecoder.ENCODED_LENGTH,
                    headerDecoder.blockLength(),
                    headerDecoder.version());

                long clOrdID = orderDecoder.clOrdID();
                Side side = orderDecoder.side();
                int qty = orderDecoder.orderQty();
                PriceDecoder price = orderDecoder.price();

                System.out.printf(
                    "Received order: ID=%d, Side=%d, Qty=%d, Price=%s%n",
                    clOrdID, side.value(), qty, price.toString());
              } else {
                System.out.println("Unknown message with templateId: " + templateId);
              }
            };

        // Poll from the subscription
        int fragmentsRead = subscription.poll(handler, 10);
      }
    }
    mediaDriver.close();
  }
}
