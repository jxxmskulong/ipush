package com.cold.ipush;


/**
 * Created by faker on 2017/4/8.
 */
public class Request {

    private Command command;
    private Connection connection;
    private Packet packet;

    public Request(Packet packet, Connection connection) {
        this.connection = connection;
        this.packet = packet;
    }

    public Command getCommand() {
        return command;
    }

    public Connection getConnection() {
        return connection;
    }

    public Packet getPacket() {
        return packet;
    }

    public Response getResponse() {
        return new Response(packet, connection);
    }

}
