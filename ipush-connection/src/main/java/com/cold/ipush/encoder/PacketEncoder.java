package com.cold.ipush.encoder;

import com.cold.ipush.Constants;
import com.cold.ipush.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by faker on 2017/4/8.
 */
public class PacketEncoder extends MessageToByteEncoder<Packet>{
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        out.writeByte(Constants.MAGIC_NUM1);
        out.writeByte(Constants.MAGIC_NUM2);
        out.writeInt(packet.getBodyLength());
        out.writeByte(packet.command);
        out.writeByte(packet.flags);
        out.writeByte(packet.version);
        out.writeInt(packet.msgId);
        if (packet.getBodyLength() > 0) {
            out.writeBytes(packet.body);
        }
    }
}
