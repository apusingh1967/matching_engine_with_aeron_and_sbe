/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class RejectEncoder {
  public static final int BLOCK_LENGTH = 24;
  public static final int TEMPLATE_ID = 7;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final RejectEncoder parentMessage = this;
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

  public RejectEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public RejectEncoder wrapAndApplyHeader(
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

  public static int refSeqNumId() {
    return 45;
  }

  public static int refSeqNumSinceVersion() {
    return 0;
  }

  public static int refSeqNumEncodingOffset() {
    return 0;
  }

  public static int refSeqNumEncodingLength() {
    return 4;
  }

  public static String refSeqNumMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long refSeqNumNullValue() {
    return 4294967295L;
  }

  public static long refSeqNumMinValue() {
    return 0L;
  }

  public static long refSeqNumMaxValue() {
    return 4294967294L;
  }

  public RejectEncoder refSeqNum(final long value) {
    buffer.putInt(offset + 0, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int refMsgTypeId() {
    return 372;
  }

  public static String refMsgTypeCharacterEncoding() {
    return java.nio.charset.StandardCharsets.UTF_8.name();
  }

  public static String refMsgTypeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int refMsgTypeHeaderLength() {
    return 2;
  }

  public RejectEncoder putRefMsgType(
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

  public RejectEncoder putRefMsgType(final byte[] src, final int srcOffset, final int length) {
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

  public RejectEncoder refMsgType(final String value) {
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

  public static int textId() {
    return 58;
  }

  public static String textCharacterEncoding() {
    return java.nio.charset.StandardCharsets.UTF_8.name();
  }

  public static String textMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int textHeaderLength() {
    return 2;
  }

  public RejectEncoder putText(final DirectBuffer src, final int srcOffset, final int length) {
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

  public RejectEncoder putText(final byte[] src, final int srcOffset, final int length) {
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

  public RejectEncoder text(final String value) {
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

    final RejectDecoder decoder = new RejectDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
