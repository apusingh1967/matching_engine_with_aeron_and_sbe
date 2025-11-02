/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public final class ExecutionReportDecoder
{
    public static final int BLOCK_LENGTH = 48;
    public static final int TEMPLATE_ID = 6;
    public static final int SCHEMA_ID = 0;
    public static final int SCHEMA_VERSION = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final ExecutionReportDecoder parentMessage = this;
    private DirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;
    int actingBlockLength;
    int actingVersion;

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

    public DirectBuffer buffer()
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

    public ExecutionReportDecoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public ExecutionReportDecoder wrapAndApplyHeader(
        final DirectBuffer buffer,
        final int offset,
        final MessageHeaderDecoder headerDecoder)
    {
        headerDecoder.wrap(buffer, offset);

        final int templateId = headerDecoder.templateId();
        if (TEMPLATE_ID != templateId)
        {
            throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
        }

        return wrap(
            buffer,
            offset + MessageHeaderDecoder.ENCODED_LENGTH,
            headerDecoder.blockLength(),
            headerDecoder.version());
    }

    public ExecutionReportDecoder sbeRewind()
    {
        return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
    }

    public int sbeDecodedLength()
    {
        final int currentLimit = limit();
        sbeSkip();
        final int decodedLength = encodedLength();
        limit(currentLimit);

        return decodedLength;
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

    public long orderID()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public long clOrdID()
    {
        return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public long execID()
    {
        return buffer.getLong(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public short sideRaw()
    {
        return ((short)(buffer.getByte(offset + 24) & 0xFF));
    }

    public Side side()
    {
        return Side.get(((short)(buffer.getByte(offset + 24) & 0xFF)));
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

    public short execTypeRaw()
    {
        return ((short)(buffer.getByte(offset + 25) & 0xFF));
    }

    public ExecType execType()
    {
        return ExecType.get(((short)(buffer.getByte(offset + 25) & 0xFF)));
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

    public short ordStatusRaw()
    {
        return ((short)(buffer.getByte(offset + 26) & 0xFF));
    }

    public OrdStatus ordStatus()
    {
        return OrdStatus.get(((short)(buffer.getByte(offset + 26) & 0xFF)));
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

    public int filledQty()
    {
        return buffer.getInt(offset + 27, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public int leavesQty()
    {
        return buffer.getInt(offset + 31, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    private final PriceDecoder price = new PriceDecoder();

    public PriceDecoder price()
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

    private final VarStringEncodingDecoder senderCompID = new VarStringEncodingDecoder();

    public VarStringEncodingDecoder senderCompID()
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

    private final VarStringEncodingDecoder targetCompID = new VarStringEncodingDecoder();

    public VarStringEncodingDecoder targetCompID()
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

        final ExecutionReportDecoder decoder = new ExecutionReportDecoder();
        decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[ExecutionReport](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("orderID=");
        builder.append(this.orderID());
        builder.append('|');
        builder.append("clOrdID=");
        builder.append(this.clOrdID());
        builder.append('|');
        builder.append("execID=");
        builder.append(this.execID());
        builder.append('|');
        builder.append("side=");
        builder.append(this.side());
        builder.append('|');
        builder.append("execType=");
        builder.append(this.execType());
        builder.append('|');
        builder.append("ordStatus=");
        builder.append(this.ordStatus());
        builder.append('|');
        builder.append("filledQty=");
        builder.append(this.filledQty());
        builder.append('|');
        builder.append("leavesQty=");
        builder.append(this.leavesQty());
        builder.append('|');
        builder.append("price=");
        final PriceDecoder price = this.price();
        if (price != null)
        {
            price.appendTo(builder);
        }
        else
        {
            builder.append("null");
        }
        builder.append('|');

        limit(originalLimit);

        return builder;
    }
    
    public ExecutionReportDecoder sbeSkip()
    {
        sbeRewind();

        return this;
    }
}
