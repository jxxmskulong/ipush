package com.cold.ipush.handler;

import com.cold.ipush.NettyConnection;
import com.cold.ipush.MessageReceiver;
import com.cold.ipush.Request;
import com.cold.ipush.protocol.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectionHandler extends ChannelInboundHandlerAdapter {

    private MessageReceiver receiver = new MessageReceiver();
    private NettyConnection connection = new NettyConnection();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        receiver.onMessage(new Request((Packet) msg, connection));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
