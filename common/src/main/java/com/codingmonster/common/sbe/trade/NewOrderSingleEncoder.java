/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class NewOrderSingleEncoder {
  public static final int BLOCK_LENGTH = 32;
  public static final int TEMPLATE_ID = 1;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final NewOrderSingleEncoder parentMessage = this;
  private MutableDirectBuffer buffer;
  private int initialOffset;
  private int offset;
  private int limit;

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

  public MutableDirectBuffer buffer() {
    return buffer;
  }

  public int initialOffset() {
    return initialOffset;
  }

  public int offset() {
    return offset;
  }

  public NewOrderSingleEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public NewOrderSingleEncoder wrapAndApplyHeader(
      final MutableDirectBuffer buffer,
      final int offset,
      final MessageHeaderEncoder headerEncoder) {
    headerEncoder
        .wrap(buffer, offset)
        .blockLength(BLOCK_LENGTH)
        .templateId(TEMPLATE_ID)
        .schemaId(SCHEMA_ID)
        .version(SCHEMA_VERSION);

    return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
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

  public static int clOrdIDId() {
    return 11;
  }

  public static int clOrdIDSinceVersion() {
    return 0;
  }

  public static int clOrdIDEncodingOffset() {
    return 0;
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

  public NewOrderSingleEncoder clOrdID(final long value) {
    buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int sideId() {
    return 54;
  }

  public static int sideSinceVersion() {
    return 0;
  }

  public static int sideEncodingOffset() {
    return 8;
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

  public NewOrderSingleEncoder side(final Side value) {
    buffer.putByte(offset + 8, (byte) value.value());
    return this;
  }

  public static int orderQtyId() {
    return 38;
  }

  public static int orderQtySinceVersion() {
    return 0;
  }

  public static int orderQtyEncodingOffset() {
    return 9;
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

  public NewOrderSingleEncoder orderQty(final int value) {
    buffer.putInt(offset + 9, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int priceId() {
    return 44;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 13;
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

  private final PriceEncoder price = new PriceEncoder();

  public PriceEncoder price() {
    price.wrap(buffer, offset + 13);
    return price;
  }

  public static int orderTypeId() {
    return 40;
  }

  public static int orderTypeSinceVersion() {
    return 0;
  }

  public static int orderTypeEncodingOffset() {
    return 22;
  }

  public static int orderTypeEncodingLength() {
    return 1;
  }

  public static String orderTypeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public NewOrderSingleEncoder orderType(final OrderType value) {
    buffer.putByte(offset + 22, (byte) value.value());
    return this;
  }

  public static int timeInForceId() {
    return 8;
  }

  public static int timeInForceSinceVersion() {
    return 0;
  }

  public static int timeInForceEncodingOffset() {
    return 23;
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

  public NewOrderSingleEncoder timeInForce(final TimeInForce value) {
    buffer.putByte(offset + 23, (byte) value.value());
    return this;
  }

  public static int timestampId() {
    return 9;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return 24;
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

  public NewOrderSingleEncoder timestamp(final long value) {
    buffer.putLong(offset + 24, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int symbolId() {
    return 55;
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

  public NewOrderSingleEncoder putSymbol(
      final DirectBuffer src, final int srcOffset, final int length) {
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, src, srcOffset, length);

    return this;
  }

  public NewOrderSingleEncoder putSymbol(final byte[] src, final int srcOffset, final int length) {
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, src, srcOffset, length);

    return this;
  }

  public NewOrderSingleEncoder symbol(final String value) {
    final byte[] bytes =
        (null == value || value.isEmpty())
            ? org.agrona.collections.ArrayUtil.EMPTY_BYTE_ARRAY
            : value.getBytes(java.nio.charset.StandardCharsets.UTF_8);

    final int length = bytes.length;
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, bytes, 0, length);

    return this;
  }

  public static int senderCompIDId() {
    return 49;
  }

  public static String senderCompIDCharacterEncoding() {
    return java.nio.charset.StandardCharsets.UTF_8.name();
  }

  public static String senderCompIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int senderCompIDHeaderLength() {
    return 2;
  }

  public NewOrderSingleEncoder putSenderCompID(
      final DirectBuffer src, final int srcOffset, final int length) {
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, src, srcOffset, length);

    return this;
  }

  public NewOrderSingleEncoder putSenderCompID(
      final byte[] src, final int srcOffset, final int length) {
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, src, srcOffset, length);

    return this;
  }

  public NewOrderSingleEncoder senderCompID(final String value) {
    final byte[] bytes =
        (null == value || value.isEmpty())
            ? org.agrona.collections.ArrayUtil.EMPTY_BYTE_ARRAY
            : value.getBytes(java.nio.charset.StandardCharsets.UTF_8);

    final int length = bytes.length;
    if (length > 65534) {
      throw new IllegalStateException("length > maxValue for type: " + length);
    }

    final int headerLength = 2;
    final int limit = parentMessage.limit();
    parentMessage.limit(limit + headerLength + length);
    buffer.putShort(limit, (short) length, java.nio.ByteOrder.LITTLE_ENDIAN);
    buffer.putBytes(limit + headerLength, bytes, 0, length);

    return this;
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    return appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final NewOrderSingleDecoder decoder = new NewOrderSingleDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
