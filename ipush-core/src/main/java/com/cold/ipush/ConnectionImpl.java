package com.cold.ipush;

import com.cold.ipush.protocol.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectionImpl implements Connection{

    private ConnectionInfo info;
    private Channel channel;
    private int status = 0;
    private long lastHeartbeatTime = 0;

    public void init(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String getId() {
        return channel.toString();
    }

    @Override
    public void send(Packet packet) {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }


    public ChannelFuture close() {
        return null;
    }

    public ConnectionInfo getInfo() {
        return info;
    }

    public void setInfo(ConnectionInfo info) {
        this.info = info;
    }

    public Channel getChannel() {
        return channel;
    }
}
