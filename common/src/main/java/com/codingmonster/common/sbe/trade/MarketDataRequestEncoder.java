/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class MarketDataRequestEncoder {
  public static final int BLOCK_LENGTH = 16;
  public static final int TEMPLATE_ID = 4;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final MarketDataRequestEncoder parentMessage = this;
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

  public MarketDataRequestEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public MarketDataRequestEncoder wrapAndApplyHeader(
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

  public static int mdReqIDId() {
    return 262;
  }

  public static int mdReqIDSinceVersion() {
    return 0;
  }

  public static int mdReqIDEncodingOffset() {
    return 0;
  }

  public static int mdReqIDEncodingLength() {
    return 8;
  }

  public static String mdReqIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long mdReqIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long mdReqIDMinValue() {
    return 0x0L;
  }

  public static long mdReqIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public MarketDataRequestEncoder mdReqID(final long value) {
    buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public MarketDataRequestEncoder putSymbol(
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

  public MarketDataRequestEncoder putSymbol(
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

  public MarketDataRequestEncoder symbol(final String value) {
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

    final MarketDataRequestDecoder decoder = new MarketDataRequestDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
