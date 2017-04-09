package com.cold.ipush;


import com.cold.ipush.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by faker on 2017/4/8.
 */
public class PacketDecoder extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            while (in.readableBytes() >= Constants.HEADER_LEN) {
                //记录位置，如果读取到的是不完整的帧，要恢复到此为止，便于下次读取
                in.markReaderIndex();
                out.add(decodeFrame(in));
            }
        } catch (Exception e) {
            in.resetReaderIndex();
        }
    }

    private Object decodeFrame(ByteBuf in) {
        int size = in.readableBytes();
        if (in.readByte() != Constants.MAGIC_NUM1 || in.readByte() != Constants.MAGIC_NUM2) {
            throw new RuntimeException("ERROR MAGIC_NUM");
        }

        int bodyLength = in.readInt();
        if (size < (bodyLength + Constants.HEADER_LEN)) {
            throw new RuntimeException("invalid frame");
        }

        return readPacket(in, bodyLength);
    }

    private Packet readPacket(ByteBuf in, int bodyLength) {
        byte command = in.readByte();
        byte version = in.readByte();
        byte flags = in.readByte();
        int msgId = in.readInt();
        byte[] body = null;
        if (bodyLength > 0) {
            if (bodyLength > Constants.MAX_PACKET_SIZE) {
                throw new RuntimeException("ERROR PACKET_SIZE：" + bodyLength);
            }
            body = new byte[bodyLength];
            in.readBytes(body);
        }
        Packet packet = new Packet();
        packet.command = command;
        packet.version = version;
        packet.flags = flags;
        packet.msgId = msgId;
        packet.body = body;
        return packet;
    }
}
