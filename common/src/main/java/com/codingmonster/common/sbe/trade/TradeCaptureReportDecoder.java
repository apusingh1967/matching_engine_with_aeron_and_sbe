/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class TradeCaptureReportDecoder {
  public static final int BLOCK_LENGTH = 48;
  public static final int TEMPLATE_ID = 9;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final TradeCaptureReportDecoder parentMessage = this;
  private DirectBuffer buffer;
  private int initialOffset;
  private int offset;
  private int limit;
  int actingBlockLength;
  int actingVersion;

  public int sbeBlockLength() {
    return BLOCK_LENGTH;
  }

  public int sbeTemplateId() {
    return TEMPLATE_ID;
  }

  public int sbeSchemaId() {
    return SCHEMA_ID;
  }

  public int sbeSchemaVersion() {
    return SCHEMA_VERSION;
  }

  public String sbeSemanticType() {
    return "";
  }

  public DirectBuffer buffer() {
    return buffer;
  }

  public int initialOffset() {
    return initialOffset;
  }

  public int offset() {
    return offset;
  }

  public TradeCaptureReportDecoder wrap(
      final DirectBuffer buffer,
      final int offset,
      final int actingBlockLength,
      final int actingVersion) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    this.actingBlockLength = actingBlockLength;
    this.actingVersion = actingVersion;
    limit(offset + actingBlockLength);

    return this;
  }

  public TradeCaptureReportDecoder wrapAndApplyHeader(
      final DirectBuffer buffer, final int offset, final MessageHeaderDecoder headerDecoder) {
    headerDecoder.wrap(buffer, offset);

    final int templateId = headerDecoder.templateId();
    if (TEMPLATE_ID != templateId) {
      throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
    }

    return wrap(
        buffer,
        offset + MessageHeaderDecoder.ENCODED_LENGTH,
        headerDecoder.blockLength(),
        headerDecoder.version());
  }

  public TradeCaptureReportDecoder sbeRewind() {
    return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
  }

  public int sbeDecodedLength() {
    final int currentLimit = limit();
    sbeSkip();
    final int decodedLength = encodedLength();
    limit(currentLimit);

    return decodedLength;
  }

  public int encodedLength() {
    return limit - offset;
  }

  public int limit() {
    return limit;
  }

  public void limit(final int limit) {
    this.limit = limit;
  }

  public static int tradeIDId() {
    return 1003;
  }

  public static int tradeIDSinceVersion() {
    return 0;
  }

  public static int tradeIDEncodingOffset() {
    return 0;
  }

  public static int tradeIDEncodingLength() {
    return 8;
  }

  public static String tradeIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long tradeIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long tradeIDMinValue() {
    return 0x0L;
  }

  public static long tradeIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long tradeID() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int orderIDId() {
    return 37;
  }

  public static int orderIDSinceVersion() {
    return 0;
  }

  public static int orderIDEncodingOffset() {
    return 8;
  }

  public static int orderIDEncodingLength() {
    return 8;
  }

  public static String orderIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long orderIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long orderIDMinValue() {
    return 0x0L;
  }

  public static long orderIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long orderID() {
    return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int sideId() {
    return 54;
  }

  public static int sideSinceVersion() {
    return 0;
  }

  public static int sideEncodingOffset() {
    return 16;
  }

  public static int sideEncodingLength() {
    return 1;
  }

  public static String sideMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public short sideRaw() {
    return ((short) (buffer.getByte(offset + 16) & 0xFF));
  }

  public Side side() {
    return Side.get(((short) (buffer.getByte(offset + 16) & 0xFF)));
  }

  public static int quantityId() {
    return 53;
  }

  public static int quantitySinceVersion() {
    return 0;
  }

  public static int quantityEncodingOffset() {
    return 17;
  }

  public static int quantityEncodingLength() {
    return 4;
  }

  public static String quantityMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int quantityNullValue() {
    return -2147483648;
  }

  public static int quantityMinValue() {
    return -2147483647;
  }

  public static int quantityMaxValue() {
    return 2147483647;
  }

  public int quantity() {
    return buffer.getInt(offset + 17, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int priceId() {
    return 44;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 21;
  }

  public static int priceEncodingLength() {
    return 9;
  }

  public static String priceMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  private final PriceDecoder price = new PriceDecoder();

  public PriceDecoder price() {
    price.wrap(buffer, offset + 21);
    return price;
  }

  public static int tradeTimeId() {
    return 60;
  }

  public static int tradeTimeSinceVersion() {
    return 0;
  }

  public static int tradeTimeEncodingOffset() {
    return 30;
  }

  public static int tradeTimeEncodingLength() {
    return 8;
  }

  public static String tradeTimeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long tradeTimeNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long tradeTimeMinValue() {
    return 0x0L;
  }

  public static long tradeTimeMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long tradeTime() {
    return buffer.getLong(offset + 30, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int symbolId() {
    return 55;
  }

  public static int symbolSinceVersion() {
    return 0;
  }

  public static String symbolCharacterEncoding() {
    return java.nio.charset.StandardCharsets.UTF_8.name();
  }

  public static String symbolMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int symbolHeaderLength() {
    return 2;
  }

  public int symbolLength() {
    final int limit = parentMessage.limit();
    return (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
  }

  public int skipSymbol() {
    final int headerLength = 2;
    final int limit = parentMessage.limit();
    final int dataLength = (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    final int dataOffset = limit + headerLength;
    parentMessage.limit(dataOffset + dataLength);

    return dataLength;
  }

  public int getSymbol(final MutableDirectBuffer dst, final int dstOffset, final int length) {
    final int headerLength = 2;
    final int limit = parentMessage.limit();
    final int dataLength = (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    final int bytesCopied = Math.min(length, dataLength);
    parentMessage.limit(limit + headerLength + dataLength);
    buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

    return bytesCopied;
  }

  public int getSymbol(final byte[] dst, final int dstOffset, final int length) {
    final int headerLength = 2;
    final int limit = parentMessage.limit();
    final int dataLength = (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    final int bytesCopied = Math.min(length, dataLength);
    parentMessage.limit(limit + headerLength + dataLength);
    buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

    return bytesCopied;
  }

  public void wrapSymbol(final DirectBuffer wrapBuffer) {
    final int headerLength = 2;
    final int limit = parentMessage.limit();
    final int dataLength = (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    parentMessage.limit(limit + headerLength + dataLength);
    wrapBuffer.wrap(buffer, limit + headerLength, dataLength);
  }

  public String symbol() {
    final int headerLength = 2;
    final int limit = parentMessage.limit();
    final int dataLength = (buffer.getShort(limit, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    parentMessage.limit(limit + headerLength + dataLength);

    if (0 == dataLength) {
      return "";
    }

    final byte[] tmp = new byte[dataLength];
    buffer.getBytes(limit + headerLength, tmp, 0, dataLength);

    return new String(tmp, java.nio.charset.StandardCharsets.UTF_8);
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    final TradeCaptureReportDecoder decoder = new TradeCaptureReportDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[TradeCaptureReport](sbeTemplateId=");
    builder.append(TEMPLATE_ID);
    builder.append("|sbeSchemaId=");
    builder.append(SCHEMA_ID);
    builder.append("|sbeSchemaVersion=");
    if (parentMessage.actingVersion != SCHEMA_VERSION) {
      builder.append(parentMessage.actingVersion);
      builder.append('/');
    }
    builder.append(SCHEMA_VERSION);
    builder.append("|sbeBlockLength=");
    if (actingBlockLength != BLOCK_LENGTH) {
      builder.append(actingBlockLength);
      builder.append('/');
    }
    builder.append(BLOCK_LENGTH);
    builder.append("):");
    builder.append("tradeID=");
    builder.append(this.tradeID());
    builder.append('|');
    builder.append("orderID=");
    builder.append(this.orderID());
    builder.append('|');
    builder.append("side=");
    builder.append(this.side());
    builder.append('|');
    builder.append("quantity=");
    builder.append(this.quantity());
    builder.append('|');
    builder.append("price=");
    final PriceDecoder price = this.price();
    if (price != null) {
      price.appendTo(builder);
    } else {
      builder.append("null");
    }
    builder.append('|');
    builder.append("tradeTime=");
    builder.append(this.tradeTime());
    builder.append('|');
    builder.append("symbol=");
    builder.append('\'').append(symbol()).append('\'');

    limit(originalLimit);

    return builder;
  }

  public TradeCaptureReportDecoder sbeSkip() {
    sbeRewind();
    skipSymbol();

    return this;
  }
}
