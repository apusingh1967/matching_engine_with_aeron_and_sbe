/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class OrderCancelReplaceRequestDecoder {
  public static final int BLOCK_LENGTH = 40;
  public static final int TEMPLATE_ID = 2;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final OrderCancelReplaceRequestDecoder parentMessage = this;
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

  public OrderCancelReplaceRequestDecoder wrap(
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

  public OrderCancelReplaceRequestDecoder wrapAndApplyHeader(
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

  public OrderCancelReplaceRequestDecoder sbeRewind() {
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

  public static int origClOrdIDId() {
    return 41;
  }

  public static int origClOrdIDSinceVersion() {
    return 0;
  }

  public static int origClOrdIDEncodingOffset() {
    return 0;
  }

  public static int origClOrdIDEncodingLength() {
    return 8;
  }

  public static String origClOrdIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long origClOrdIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long origClOrdIDMinValue() {
    return 0x0L;
  }

  public static long origClOrdIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long origClOrdID() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int clOrdIDId() {
    return 11;
  }

  public static int clOrdIDSinceVersion() {
    return 0;
  }

  public static int clOrdIDEncodingOffset() {
    return 8;
  }

  public static int clOrdIDEncodingLength() {
    return 8;
  }

  public static String clOrdIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long clOrdIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long clOrdIDMinValue() {
    return 0x0L;
  }

  public static long clOrdIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long clOrdID() {
    return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int orderQtyId() {
    return 38;
  }

  public static int orderQtySinceVersion() {
    return 0;
  }

  public static int orderQtyEncodingOffset() {
    return 16;
  }

  public static int orderQtyEncodingLength() {
    return 4;
  }

  public static String orderQtyMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int orderQtyNullValue() {
    return -2147483648;
  }

  public static int orderQtyMinValue() {
    return -2147483647;
  }

  public static int orderQtyMaxValue() {
    return 2147483647;
  }

  public int orderQty() {
    return buffer.getInt(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int priceId() {
    return 44;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 20;
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
    price.wrap(buffer, offset + 20);
    return price;
  }

  public static int timeInForceId() {
    return 8;
  }

  public static int timeInForceSinceVersion() {
    return 0;
  }

  public static int timeInForceEncodingOffset() {
    return 29;
  }

  public static int timeInForceEncodingLength() {
    return 1;
  }

  public static String timeInForceMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public short timeInForceRaw() {
    return ((short) (buffer.getByte(offset + 29) & 0xFF));
  }

  public TimeInForce timeInForce() {
    return TimeInForce.get(((short) (buffer.getByte(offset + 29) & 0xFF)));
  }

  public static int timestampId() {
    return 9;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return 30;
  }

  public static int timestampEncodingLength() {
    return 8;
  }

  public static String timestampMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long timestampNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long timestampMinValue() {
    return 0x0L;
  }

  public static long timestampMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long timestamp() {
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

    final OrderCancelReplaceRequestDecoder decoder = new OrderCancelReplaceRequestDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[OrderCancelReplaceRequest](sbeTemplateId=");
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
    builder.append("origClOrdID=");
    builder.append(this.origClOrdID());
    builder.append('|');
    builder.append("clOrdID=");
    builder.append(this.clOrdID());
    builder.append('|');
    builder.append("orderQty=");
    builder.append(this.orderQty());
    builder.append('|');
    builder.append("price=");
    final PriceDecoder price = this.price();
    if (price != null) {
      price.appendTo(builder);
    } else {
      builder.append("null");
    }
    builder.append('|');
    builder.append("timeInForce=");
    builder.append(this.timeInForce());
    builder.append('|');
    builder.append("timestamp=");
    builder.append(this.timestamp());
    builder.append('|');
    builder.append("symbol=");
    builder.append('\'').append(symbol()).append('\'');

    limit(originalLimit);

    return builder;
  }

  public OrderCancelReplaceRequestDecoder sbeSkip() {
    sbeRewind();
    skipSymbol();

    return this;
  }
}
