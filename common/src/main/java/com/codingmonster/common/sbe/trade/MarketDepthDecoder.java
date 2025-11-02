/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;

/** Market Depth */
@SuppressWarnings("all")
public final class MarketDepthDecoder {
  public static final int BLOCK_LENGTH = 12;
  public static final int TEMPLATE_ID = 1000;
  public static final int SCHEMA_ID = 0;
  public static final int SCHEMA_VERSION = 1;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final MarketDepthDecoder parentMessage = this;
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

  public MarketDepthDecoder wrap(
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

  public MarketDepthDecoder wrapAndApplyHeader(
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

  public MarketDepthDecoder sbeRewind() {
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

  public static int sequenceIdId() {
    return 1001;
  }

  public static int sequenceIdSinceVersion() {
    return 0;
  }

  public static int sequenceIdEncodingOffset() {
    return 0;
  }

  public static int sequenceIdEncodingLength() {
    return 8;
  }

  public static String sequenceIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long sequenceIdNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long sequenceIdMinValue() {
    return 0x0L;
  }

  public static long sequenceIdMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long sequenceId() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int instrumentIdId() {
    return 1002;
  }

  public static int instrumentIdSinceVersion() {
    return 0;
  }

  public static int instrumentIdEncodingOffset() {
    return 8;
  }

  public static int instrumentIdEncodingLength() {
    return 4;
  }

  public static String instrumentIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long instrumentIdNullValue() {
    return 4294967295L;
  }

  public static long instrumentIdMinValue() {
    return 0L;
  }

  public static long instrumentIdMaxValue() {
    return 4294967294L;
  }

  public long instrumentId() {
    return (buffer.getInt(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
  }

  public static int symbolId() {
    return 1003;
  }

  public static int symbolSinceVersion() {
    return 0;
  }

  public static int symbolEncodingOffset() {
    return 12;
  }

  public static int symbolEncodingLength() {
    return -1;
  }

  public static String symbolMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  private final VarStringEncodingDecoder symbol = new VarStringEncodingDecoder();

  public VarStringEncodingDecoder symbol() {
    symbol.wrap(buffer, offset + 12);
    return symbol;
  }

  public static int exchangeId() {
    return 1004;
  }

  public static int exchangeSinceVersion() {
    return 0;
  }

  public static int exchangeEncodingOffset() {
    return -1;
  }

  public static int exchangeEncodingLength() {
    return -1;
  }

  public static String exchangeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  private final VarStringEncodingDecoder exchange = new VarStringEncodingDecoder();

  public VarStringEncodingDecoder exchange() {
    exchange.wrap(buffer, offset + -1);
    return exchange;
  }

  public static int updateTypeId() {
    return 1005;
  }

  public static int updateTypeSinceVersion() {
    return 0;
  }

  public static int updateTypeEncodingOffset() {
    return -1;
  }

  public static int updateTypeEncodingLength() {
    return 1;
  }

  public static String updateTypeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static short updateTypeNullValue() {
    return (short) 255;
  }

  public static short updateTypeMinValue() {
    return (short) 0;
  }

  public static short updateTypeMaxValue() {
    return (short) 254;
  }

  public short updateType() {
    return ((short) (buffer.getByte(offset + -1) & 0xFF));
  }

  public static int timestampId() {
    return 1006;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return -1;
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
    return buffer.getLong(offset + -1, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int exchangeTimestampId() {
    return 1007;
  }

  public static int exchangeTimestampSinceVersion() {
    return 0;
  }

  public static int exchangeTimestampEncodingOffset() {
    return -1;
  }

  public static int exchangeTimestampEncodingLength() {
    return 8;
  }

  public static String exchangeTimestampMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "optional";
    }

    return "";
  }

  public static long exchangeTimestampNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long exchangeTimestampMinValue() {
    return 0x0L;
  }

  public static long exchangeTimestampMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long exchangeTimestamp() {
    return buffer.getLong(offset + -1, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  private final BookLevelDecoder bookLevel = new BookLevelDecoder(this);

  public static long bookLevelDecoderId() {
    return 1008;
  }

  public static int bookLevelDecoderSinceVersion() {
    return 0;
  }

  public BookLevelDecoder bookLevel() {
    bookLevel.wrap(buffer);
    return bookLevel;
  }

  public static final class BookLevelDecoder
      implements Iterable<BookLevelDecoder>, java.util.Iterator<BookLevelDecoder> {
    public static final int HEADER_SIZE = 3;
    private final MarketDepthDecoder parentMessage;
    private DirectBuffer buffer;
    private int count;
    private int index;
    private int offset;
    private int blockLength;
    private final EntriesDecoder entries;

    BookLevelDecoder(final MarketDepthDecoder parentMessage) {
      this.parentMessage = parentMessage;
      entries = new EntriesDecoder(parentMessage);
    }

    public void wrap(final DirectBuffer buffer) {
      if (buffer != this.buffer) {
        this.buffer = buffer;
      }

      index = 0;
      final int limit = parentMessage.limit();
      parentMessage.limit(limit + HEADER_SIZE);
      blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
      count = ((short) (buffer.getByte(limit + 2) & 0xFF));
    }

    public BookLevelDecoder next() {
      if (index >= count) {
        throw new java.util.NoSuchElementException();
      }

      offset = parentMessage.limit();
      parentMessage.limit(offset + blockLength);
      ++index;

      return this;
    }

    public static short countMinValue() {
      return (short) 0;
    }

    public static short countMaxValue() {
      return (short) 254;
    }

    public static int sbeHeaderSize() {
      return HEADER_SIZE;
    }

    public static int sbeBlockLength() {
      return 1;
    }

    public int actingBlockLength() {
      return blockLength;
    }

    public int count() {
      return count;
    }

    public java.util.Iterator<BookLevelDecoder> iterator() {
      return this;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
      return index < count;
    }

    public static int bookTypeId() {
      return 1009;
    }

    public static int bookTypeSinceVersion() {
      return 0;
    }

    public static int bookTypeEncodingOffset() {
      return 0;
    }

    public static int bookTypeEncodingLength() {
      return 1;
    }

    public static String bookTypeMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    public short bookTypeRaw() {
      return ((short) (buffer.getByte(offset + 0) & 0xFF));
    }

    public MDEntryType bookType() {
      return MDEntryType.get(((short) (buffer.getByte(offset + 0) & 0xFF)));
    }

    public static long entriesDecoderId() {
      return 1010;
    }

    public static int entriesDecoderSinceVersion() {
      return 0;
    }

    public EntriesDecoder entries() {
      entries.wrap(buffer);
      return entries;
    }

    public static final class EntriesDecoder
        implements Iterable<EntriesDecoder>, java.util.Iterator<EntriesDecoder> {
      public static final int HEADER_SIZE = 3;
      private final MarketDepthDecoder parentMessage;
      private DirectBuffer buffer;
      private int count;
      private int index;
      private int offset;
      private int blockLength;

      EntriesDecoder(final MarketDepthDecoder parentMessage) {
        this.parentMessage = parentMessage;
      }

      public void wrap(final DirectBuffer buffer) {
        if (buffer != this.buffer) {
          this.buffer = buffer;
        }

        index = 0;
        final int limit = parentMessage.limit();
        parentMessage.limit(limit + HEADER_SIZE);
        blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        count = ((short) (buffer.getByte(limit + 2) & 0xFF));
      }

      public EntriesDecoder next() {
        if (index >= count) {
          throw new java.util.NoSuchElementException();
        }

        offset = parentMessage.limit();
        parentMessage.limit(offset + blockLength);
        ++index;

        return this;
      }

      public static short countMinValue() {
        return (short) 0;
      }

      public static short countMaxValue() {
        return (short) 254;
      }

      public static int sbeHeaderSize() {
        return HEADER_SIZE;
      }

      public static int sbeBlockLength() {
        return 18;
      }

      public int actingBlockLength() {
        return blockLength;
      }

      public int count() {
        return count;
      }

      public java.util.Iterator<EntriesDecoder> iterator() {
        return this;
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }

      public boolean hasNext() {
        return index < count;
      }

      public static int mdEntryPxId() {
        return 1011;
      }

      public static int mdEntryPxSinceVersion() {
        return 0;
      }

      public static int mdEntryPxEncodingOffset() {
        return 0;
      }

      public static int mdEntryPxEncodingLength() {
        return 9;
      }

      public static String mdEntryPxMetaAttribute(final MetaAttribute metaAttribute) {
        if (MetaAttribute.PRESENCE == metaAttribute) {
          return "required";
        }

        return "";
      }

      private final PriceDecoder mdEntryPx = new PriceDecoder();

      public PriceDecoder mdEntryPx() {
        mdEntryPx.wrap(buffer, offset + 0);
        return mdEntryPx;
      }

      public static int mdEntryQtyId() {
        return 1012;
      }

      public static int mdEntryQtySinceVersion() {
        return 0;
      }

      public static int mdEntryQtyEncodingOffset() {
        return 9;
      }

      public static int mdEntryQtyEncodingLength() {
        return 9;
      }

      public static String mdEntryQtyMetaAttribute(final MetaAttribute metaAttribute) {
        if (MetaAttribute.PRESENCE == metaAttribute) {
          return "required";
        }

        return "";
      }

      private final QuantityDecoder mdEntryQty = new QuantityDecoder();

      public QuantityDecoder mdEntryQty() {
        mdEntryQty.wrap(buffer, offset + 9);
        return mdEntryQty;
      }

      public StringBuilder appendTo(final StringBuilder builder) {
        if (null == buffer) {
          return builder;
        }

        builder.append('(');
        builder.append("mdEntryPx=");
        final PriceDecoder mdEntryPx = this.mdEntryPx();
        if (mdEntryPx != null) {
          mdEntryPx.appendTo(builder);
        } else {
          builder.append("null");
        }
        builder.append('|');
        builder.append("mdEntryQty=");
        final QuantityDecoder mdEntryQty = this.mdEntryQty();
        if (mdEntryQty != null) {
          mdEntryQty.appendTo(builder);
        } else {
          builder.append("null");
        }
        builder.append(')');

        return builder;
      }

      public EntriesDecoder sbeSkip() {

        return this;
      }
    }

    public StringBuilder appendTo(final StringBuilder builder) {
      if (null == buffer) {
        return builder;
      }

      builder.append('(');
      builder.append("bookType=");
      builder.append(this.bookType());
      builder.append('|');
      builder.append("entries=[");
      final int entriesOriginalOffset = entries.offset;
      final int entriesOriginalIndex = entries.index;
      final EntriesDecoder entries = this.entries();
      if (entries.count() > 0) {
        while (entries.hasNext()) {
          entries.next().appendTo(builder);
          builder.append(',');
        }
        builder.setLength(builder.length() - 1);
      }
      entries.offset = entriesOriginalOffset;
      entries.index = entriesOriginalIndex;
      builder.append(']');
      builder.append(')');

      return builder;
    }

    public BookLevelDecoder sbeSkip() {
      EntriesDecoder entries = this.entries();
      if (entries.count() > 0) {
        while (entries.hasNext()) {
          entries.next();
          entries.sbeSkip();
        }
      }

      return this;
    }
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    final MarketDepthDecoder decoder = new MarketDepthDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[MarketDepth](sbeTemplateId=");
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
    builder.append("sequenceId=");
    builder.append(this.sequenceId());
    builder.append('|');
    builder.append("instrumentId=");
    builder.append(this.instrumentId());
    builder.append('|');
    builder.append("updateType=");
    builder.append(this.updateType());
    builder.append('|');
    builder.append("timestamp=");
    builder.append(this.timestamp());
    builder.append('|');
    builder.append("exchangeTimestamp=");
    builder.append(this.exchangeTimestamp());
    builder.append('|');
    builder.append("bookLevel=[");
    final int bookLevelOriginalOffset = bookLevel.offset;
    final int bookLevelOriginalIndex = bookLevel.index;
    final BookLevelDecoder bookLevel = this.bookLevel();
    if (bookLevel.count() > 0) {
      while (bookLevel.hasNext()) {
        bookLevel.next().appendTo(builder);
        builder.append(',');
      }
      builder.setLength(builder.length() - 1);
    }
    bookLevel.offset = bookLevelOriginalOffset;
    bookLevel.index = bookLevelOriginalIndex;
    builder.append(']');

    limit(originalLimit);

    return builder;
  }

  public MarketDepthDecoder sbeSkip() {
    sbeRewind();
    BookLevelDecoder bookLevel = this.bookLevel();
    if (bookLevel.count() > 0) {
      while (bookLevel.hasNext()) {
        bookLevel.next();
        bookLevel.sbeSkip();
      }
    }

    return this;
  }
}
