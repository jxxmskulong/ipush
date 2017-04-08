package com.cold.ipush;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectionImpl implements Connection{

    private ConnectionInfo info;
    private Channel channel;
    private int status = 0;

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
