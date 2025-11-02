/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class TradeCaptureReportEncoder {
  public static final int BLOCK_LENGTH = 48;
  public static final int TEMPLATE_ID = 9;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final TradeCaptureReportEncoder parentMessage = this;
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

  public TradeCaptureReportEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public TradeCaptureReportEncoder wrapAndApplyHeader(
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

  public TradeCaptureReportEncoder tradeID(final long value) {
    buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
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

  public TradeCaptureReportEncoder orderID(final long value) {
    buffer.putLong(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
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

  public TradeCaptureReportEncoder side(final Side value) {
    buffer.putByte(offset + 16, (byte) value.value());
    return this;
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

  public TradeCaptureReportEncoder quantity(final int value) {
    buffer.putInt(offset + 17, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
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

  private final PriceEncoder price = new PriceEncoder();

  public PriceEncoder price() {
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

  public TradeCaptureReportEncoder tradeTime(final long value) {
    buffer.putLong(offset + 30, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public TradeCaptureReportEncoder putSymbol(
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

  public TradeCaptureReportEncoder putSymbol(
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

  public TradeCaptureReportEncoder symbol(final String value) {
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

    final TradeCaptureReportDecoder decoder = new TradeCaptureReportDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
