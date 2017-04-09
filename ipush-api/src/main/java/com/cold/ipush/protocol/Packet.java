package com.cold.ipush.protocol;

/**
 * Created by faker on 2017/4/8.
 */
public class Packet {
    public byte command;
    public int version;
    public byte flags;
    public int msgId;
    public byte[] body;

    public int getBodyLength() {
        return body == null ? 0 : body.length;
    }
}
