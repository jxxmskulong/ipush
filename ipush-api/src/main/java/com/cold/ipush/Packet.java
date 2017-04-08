package com.cold.ipush;

/**
 * Created by faker on 2017/4/8.
 */
public class Packet {
    public byte command;
    public int version;
    public byte flags;
    public int msgId;
    public int msgType;
    public byte[] body;

}
