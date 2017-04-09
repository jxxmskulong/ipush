package com.cold.ipush;

import com.cold.ipush.protocol.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by faker on 2017/4/8.
 */
public class NettyConnection implements Connection{

    private static final Logger log = LoggerFactory.getLogger(NettyConnection.class);

    private ConnectionInfo info;
    private Channel channel;
    private int status = 0;
    private long lastHeartbeatTime = 0;

    public void init(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String remoteIp() {
        return null;
    }

    @Override
    public String getId() {
        return channel.toString();
    }

    @Override
    public void send(Packet packet) {
        if (packet != null) {
            if (channel.isWritable()) {
                ChannelFuture wf = channel.writeAndFlush(packet);
                wf.addListener((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        log.error("server write response error,request id is: " + packet.toString());
                        if (!channel.isActive()) {
                            channel.close();
                        }
                    }
                });
            }else{
                //TODO
            }
        }
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public int getHbTimes() {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public boolean isEnable() {
        return false;
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
