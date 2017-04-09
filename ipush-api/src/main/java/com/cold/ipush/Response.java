package com.cold.ipush;

import com.cold.ipush.protocol.Packet;

/**
 * Created by faker on 2017/4/8.
 */
public class Response {
    private final Packet packet;
    private final Connection connection;

    public Response(Packet packet, Connection connection) {
        this.packet = packet;
        this.connection = connection;
    }

    public void send(byte[] body) {
        packet.body = body;
        connection.send(packet);
    }


    public void sendError(byte[] reson) {

    }

}
