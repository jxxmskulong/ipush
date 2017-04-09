package com.cold.ipush;

import com.cold.ipush.protocol.Packet;

/**
 * Created by faker on 2017/4/8.
 */
public interface Connection {

    String getId();

    void send(Packet packet);

    boolean isClosed();

    boolean isOpen();
}
