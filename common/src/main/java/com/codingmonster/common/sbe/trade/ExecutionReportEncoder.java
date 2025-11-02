/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class ExecutionReportEncoder
{
    public static final int BLOCK_LENGTH = 48;
    public static final int TEMPLATE_ID = 6;
    public static final int SCHEMA_ID = 0;
    public static final int SCHEMA_VERSION = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final ExecutionReportEncoder parentMessage = this;
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

    public ExecutionReportEncoder wrap(final MutableDirectBuffer buffer, final int offset)
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

    public ExecutionReportEncoder wrapAndApplyHeader(
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

    public static int orderIDId()
    {
        return 37;
    }

    public static int orderIDSinceVersion()
    {
        return 0;
    }

    public static int orderIDEncodingOffset()
    {
        return 0;
    }

    public static int orderIDEncodingLength()
    {
        return 8;
    }

    public static String orderIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long orderIDNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long orderIDMinValue()
    {
        return 0x0L;
    }

    public static long orderIDMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public ExecutionReportEncoder orderID(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int clOrdIDId()
    {
        return 11;
    }

    public static int clOrdIDSinceVersion()
    {
        return 0;
    }

    public static int clOrdIDEncodingOffset()
    {
        return 8;
    }

    public static int clOrdIDEncodingLength()
    {
        return 8;
    }

    public static String clOrdIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long clOrdIDNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long clOrdIDMinValue()
    {
        return 0x0L;
    }

    public static long clOrdIDMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public ExecutionReportEncoder clOrdID(final long value)
    {
        buffer.putLong(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int execIDId()
    {
        return 17;
    }

    public static int execIDSinceVersion()
    {
        return 0;
    }

    public static int execIDEncodingOffset()
    {
        return 16;
    }

    public static int execIDEncodingLength()
    {
        return 8;
    }

    public static String execIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long execIDNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long execIDMinValue()
    {
        return 0x0L;
    }

    public static long execIDMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public ExecutionReportEncoder execID(final long value)
    {
        buffer.putLong(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int sideId()
    {
        return 54;
    }

    public static int sideSinceVersion()
    {
        return 0;
    }

    public static int sideEncodingOffset()
    {
        return 24;
    }

    public static int sideEncodingLength()
    {
        return 1;
    }

    public static String sideMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public ExecutionReportEncoder side(final Side value)
    {
        buffer.putByte(offset + 24, (byte)value.value());
        return this;
    }

    public static int execTypeId()
    {
        return 150;
    }

    public static int execTypeSinceVersion()
    {
        return 0;
    }

    public static int execTypeEncodingOffset()
    {
        return 25;
    }

    public static int execTypeEncodingLength()
    {
        return 1;
    }

    public static String execTypeMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public ExecutionReportEncoder execType(final ExecType value)
    {
        buffer.putByte(offset + 25, (byte)value.value());
        return this;
    }

    public static int ordStatusId()
    {
        return 39;
    }

    public static int ordStatusSinceVersion()
    {
        return 0;
    }

    public static int ordStatusEncodingOffset()
    {
        return 26;
    }

    public static int ordStatusEncodingLength()
    {
        return 1;
    }

    public static String ordStatusMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public ExecutionReportEncoder ordStatus(final OrdStatus value)
    {
        buffer.putByte(offset + 26, (byte)value.value());
        return this;
    }

    public static int filledQtyId()
    {
        return 32;
    }

    public static int filledQtySinceVersion()
    {
        return 0;
    }

    public static int filledQtyEncodingOffset()
    {
        return 27;
    }

    public static int filledQtyEncodingLength()
    {
        return 4;
    }

    public static String filledQtyMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static int filledQtyNullValue()
    {
        return -2147483648;
    }

    public static int filledQtyMinValue()
    {
        return -2147483647;
    }

    public static int filledQtyMaxValue()
    {
        return 2147483647;
    }

    public ExecutionReportEncoder filledQty(final int value)
    {
        buffer.putInt(offset + 27, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int leavesQtyId()
    {
        return 151;
    }

    public static int leavesQtySinceVersion()
    {
        return 0;
    }

    public static int leavesQtyEncodingOffset()
    {
        return 31;
    }

    public static int leavesQtyEncodingLength()
    {
        return 4;
    }

    public static String leavesQtyMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static int leavesQtyNullValue()
    {
        return -2147483648;
    }

    public static int leavesQtyMinValue()
    {
        return -2147483647;
    }

    public static int leavesQtyMaxValue()
    {
        return 2147483647;
    }

    public ExecutionReportEncoder leavesQty(final int value)
    {
        buffer.putInt(offset + 31, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int priceId()
    {
        return 44;
    }

    public static int priceSinceVersion()
    {
        return 0;
    }

    public static int priceEncodingOffset()
    {
        return 35;
    }

    public static int priceEncodingLength()
    {
        return 9;
    }

    public static String priceMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    private final PriceEncoder price = new PriceEncoder();

    public PriceEncoder price()
    {
        price.wrap(buffer, offset + 35);
        return price;
    }

    public static int senderCompIDId()
    {
        return 49;
    }

    public static int senderCompIDSinceVersion()
    {
        return 0;
    }

    public static int senderCompIDEncodingOffset()
    {
        return 44;
    }

    public static int senderCompIDEncodingLength()
    {
        return -1;
    }

    public static String senderCompIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    private final VarStringEncodingEncoder senderCompID = new VarStringEncodingEncoder();

    public VarStringEncodingEncoder senderCompID()
    {
        senderCompID.wrap(buffer, offset + 44);
        return senderCompID;
    }

    public static int targetCompIDId()
    {
        return 56;
    }

    public static int targetCompIDSinceVersion()
    {
        return 0;
    }

    public static int targetCompIDEncodingOffset()
    {
        return -1;
    }

    public static int targetCompIDEncodingLength()
    {
        return -1;
    }

    public static String targetCompIDMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    private final VarStringEncodingEncoder targetCompID = new VarStringEncodingEncoder();

    public VarStringEncodingEncoder targetCompID()
    {
        targetCompID.wrap(buffer, offset + -1);
        return targetCompID;
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

        final ExecutionReportDecoder decoder = new ExecutionReportDecoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(builder);
    }
}
