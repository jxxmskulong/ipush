package com.cold.ipush;

/**
 * Created by faker on 2017/4/9.
 */
public class Constants {

    public static final int MAX_PACKET_SIZE = 1024;
    public static final int HEADER_LEN = 13;
    public static final byte MAGIC_NUM1 = (byte) 33;
    public static final byte MAGIC_NUM2 = (byte) 99;

    /**
     * netty boss 线程
     */
    public static final String NETTY_BOSS = "mg-boss";

    /**
     * netty worker 线程
     */
    public static final String NETTY_WORKER = "mg-worker";

    /**
     * connection 定期检测线程
     */
    public static final String NETTY_TIMER = "mg-timer";
}
