package com.cold.ipush;

import com.cold.ipush.protocol.Packet;
import io.netty.channel.Channel;

/**
 * Created by faker on 2017/4/8.
 */
public interface Connection {

    String getId();

    void send(Packet packet);

    boolean isClosed();

    boolean isOpen();

    int getHbTimes();

    void close();

    boolean isConnected();

    boolean isEnable();

    void init(Channel channel);

    String remoteIp();
}
