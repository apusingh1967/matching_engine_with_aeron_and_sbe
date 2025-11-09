/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.MutableDirectBuffer;


/**
 * Market Depth
 */
@SuppressWarnings("all")
public final class MarketDepthEncoder
{
    public static final int BLOCK_LENGTH = 12;
    public static final int TEMPLATE_ID = 1000;
    public static final int SCHEMA_ID = 0;
    public static final int SCHEMA_VERSION = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final MarketDepthEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public MarketDepthEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public MarketDepthEncoder wrapAndApplyHeader(
        final MutableDirectBuffer buffer, final int offset, final MessageHeaderEncoder headerEncoder)
    {
        headerEncoder
            .wrap(buffer, offset)
            .blockLength(BLOCK_LENGTH)
            .templateId(TEMPLATE_ID)
            .schemaId(SCHEMA_ID)
            .version(SCHEMA_VERSION);

        return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int sequenceIdId()
    {
        return 1001;
    }

    public static int sequenceIdSinceVersion()
    {
        return 0;
    }

    public static int sequenceIdEncodingOffset()
    {
        return 0;
    }

    public static int sequenceIdEncodingLength()
    {
        return 8;
    }

    public static String sequenceIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long sequenceIdNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long sequenceIdMinValue()
    {
        return 0x0L;
    }

    public static long sequenceIdMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public MarketDepthEncoder sequenceId(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int instrumentIdId()
    {
        return 1002;
    }

    public static int instrumentIdSinceVersion()
    {
        return 0;
    }

    public static int instrumentIdEncodingOffset()
    {
        return 8;
    }

    public static int instrumentIdEncodingLength()
    {
        return 4;
    }

    public static String instrumentIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long instrumentIdNullValue()
    {
        return 4294967295L;
    }

    public static long instrumentIdMinValue()
    {
        return 0L;
    }

    public static long instrumentIdMaxValue()
    {
        return 4294967294L;
    }

    public MarketDepthEncoder instrumentId(final long value)
    {
        buffer.putInt(offset + 8, (int)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int symbolId()
    {
        return 1003;
    }

    public static int symbolSinceVersion()
    {
        return 0;
    }

    public static int symbolEncodingOffset()
    {
        return 12;
    }

    public static int symbolEncodingLength()
    {
        return -1;
    }

    public static String symbolMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    private final VarStringEncodingEncoder symbol = new VarStringEncodingEncoder();

    public VarStringEncodingEncoder symbol()
    {
        symbol.wrap(buffer, offset + 12);
        return symbol;
    }

    public static int exchangeId()
    {
        return 1004;
    }

    public static int exchangeSinceVersion()
    {
        return 0;
    }

    public static int exchangeEncodingOffset()
    {
        return -1;
    }

    public static int exchangeEncodingLength()
    {
        return -1;
    }

    public static String exchangeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    private final VarStringEncodingEncoder exchange = new VarStringEncodingEncoder();

    public VarStringEncodingEncoder exchange()
    {
        exchange.wrap(buffer, offset + -1);
        return exchange;
    }

    public static int updateTypeId()
    {
        return 1005;
    }

    public static int updateTypeSinceVersion()
    {
        return 0;
    }

    public static int updateTypeEncodingOffset()
    {
        return -1;
    }

    public static int updateTypeEncodingLength()
    {
        return 1;
    }

    public static String updateTypeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static short updateTypeNullValue()
    {
        return (short)255;
    }

    public static short updateTypeMinValue()
    {
        return (short)0;
    }

    public static short updateTypeMaxValue()
    {
        return (short)254;
    }

    public MarketDepthEncoder updateType(final short value)
    {
        buffer.putByte(offset + -1, (byte)value);
        return this;
    }


    public static int timestampId()
    {
        return 1006;
    }

    public static int timestampSinceVersion()
    {
        return 0;
    }

    public static int timestampEncodingOffset()
    {
        return -1;
    }

    public static int timestampEncodingLength()
    {
        return 8;
    }

    public static String timestampMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long timestampNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long timestampMinValue()
    {
        return 0x0L;
    }

    public static long timestampMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public MarketDepthEncoder timestamp(final long value)
    {
        buffer.putLong(offset + -1, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int exchangeTimestampId()
    {
        return 1007;
    }

    public static int exchangeTimestampSinceVersion()
    {
        return 0;
    }

    public static int exchangeTimestampEncodingOffset()
    {
        return -1;
    }

    public static int exchangeTimestampEncodingLength()
    {
        return 8;
    }

    public static String exchangeTimestampMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "optional";
        }

        return "";
    }

    public static long exchangeTimestampNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long exchangeTimestampMinValue()
    {
        return 0x0L;
    }

    public static long exchangeTimestampMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public MarketDepthEncoder exchangeTimestamp(final long value)
    {
        buffer.putLong(offset + -1, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    private final BookLevelEncoder bookLevel = new BookLevelEncoder(this);

    public static long bookLevelId()
    {
        return 1008;
    }

    public BookLevelEncoder bookLevelCount(final int count)
    {
        bookLevel.wrap(buffer, count);
        return bookLevel;
    }

    public static final class BookLevelEncoder
    {
        public static final int HEADER_SIZE = 3;
        private final MarketDepthEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int initialLimit;
        private final EntriesEncoder entries;

        BookLevelEncoder(final MarketDepthEncoder parentMessage)
        {
            this.parentMessage = parentMessage;
            entries = new EntriesEncoder(parentMessage);
        }

        public void wrap(final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 254)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            this.count = count;
            final int limit = parentMessage.limit();
            initialLimit = limit;
            parentMessage.limit(limit + HEADER_SIZE);
            buffer.putShort(limit + 0, (short)1, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putByte(limit + 2, (byte)count);
        }

        public BookLevelEncoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public int resetCountToIndex()
        {
            count = index;
            buffer.putByte(initialLimit + 2, (byte)count);

            return count;
        }

        public static short countMinValue()
        {
            return (short)0;
        }

        public static short countMaxValue()
        {
            return (short)254;
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 1;
        }

        public static int bookTypeId()
        {
            return 1009;
        }

        public static int bookTypeSinceVersion()
        {
            return 0;
        }

        public static int bookTypeEncodingOffset()
        {
            return 0;
        }

        public static int bookTypeEncodingLength()
        {
            return 1;
        }

        public static String bookTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public BookLevelEncoder bookType(final MDEntryType value)
        {
            buffer.putByte(offset + 0, (byte)value.value());
            return this;
        }

        public static long entriesId()
        {
            return 1010;
        }

        public EntriesEncoder entriesCount(final int count)
        {
            entries.wrap(buffer, count);
            return entries;
        }

        public static final class EntriesEncoder
        {
            public static final int HEADER_SIZE = 3;
            private final MarketDepthEncoder parentMessage;
            private MutableDirectBuffer buffer;
            private int count;
            private int index;
            private int offset;
            private int initialLimit;

            EntriesEncoder(final MarketDepthEncoder parentMessage)
            {
                this.parentMessage = parentMessage;
            }

            public void wrap(final MutableDirectBuffer buffer, final int count)
            {
                if (count < 0 || count > 254)
                {
                    throw new IllegalArgumentException("count outside allowed range: count=" + count);
                }

                if (buffer != this.buffer)
                {
                    this.buffer = buffer;
                }

                index = 0;
                this.count = count;
                final int limit = parentMessage.limit();
                initialLimit = limit;
                parentMessage.limit(limit + HEADER_SIZE);
                buffer.putShort(limit + 0, (short)18, java.nio.ByteOrder.LITTLE_ENDIAN);
                buffer.putByte(limit + 2, (byte)count);
            }

            public EntriesEncoder next()
            {
                if (index >= count)
                {
                    throw new java.util.NoSuchElementException();
                }

                offset = parentMessage.limit();
                parentMessage.limit(offset + sbeBlockLength());
                ++index;

                return this;
            }

            public int resetCountToIndex()
            {
                count = index;
                buffer.putByte(initialLimit + 2, (byte)count);

                return count;
            }

            public static short countMinValue()
            {
                return (short)0;
            }

            public static short countMaxValue()
            {
                return (short)254;
            }

            public static int sbeHeaderSize()
            {
                return HEADER_SIZE;
            }

            public static int sbeBlockLength()
            {
                return 18;
            }

            public static int mdEntryPxId()
            {
                return 1011;
            }

            public static int mdEntryPxSinceVersion()
            {
                return 0;
            }

            public static int mdEntryPxEncodingOffset()
            {
                return 0;
            }

            public static int mdEntryPxEncodingLength()
            {
                return 9;
            }

            public static String mdEntryPxMetaAttribute(final MetaAttribute metaAttribute)
            {
                if (MetaAttribute.PRESENCE == metaAttribute)
                {
                    return "required";
                }

                return "";
            }

            private final PriceEncoder mdEntryPx = new PriceEncoder();

            public PriceEncoder mdEntryPx()
            {
                mdEntryPx.wrap(buffer, offset + 0);
                return mdEntryPx;
            }

            public static int mdEntryQtyId()
            {
                return 1012;
            }

            public static int mdEntryQtySinceVersion()
            {
                return 0;
            }

            public static int mdEntryQtyEncodingOffset()
            {
                return 9;
            }

            public static int mdEntryQtyEncodingLength()
            {
                return 9;
            }

            public static String mdEntryQtyMetaAttribute(final MetaAttribute metaAttribute)
            {
                if (MetaAttribute.PRESENCE == metaAttribute)
                {
                    return "required";
                }

                return "";
            }

            private final QuantityEncoder mdEntryQty = new QuantityEncoder();

            public QuantityEncoder mdEntryQty()
            {
                mdEntryQty.wrap(buffer, offset + 9);
                return mdEntryQty;
            }
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final MarketDepthDecoder decoder = new MarketDepthDecoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
