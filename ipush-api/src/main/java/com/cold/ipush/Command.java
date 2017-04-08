package com.cold.ipush;

/**
 * Created by faker on 2017/4/8.
 */
public enum Command {
    Heartbeat(1),
    Handshake(2),
    Login(3),
    Logout(4),
    Bind(5),
    Unbind(6),
    Kick(7),
    Unknown(-1);

    public final byte cmd;

    Command(int cmd) {
        this.cmd = (byte) cmd;
    }

    public static Command toCommand(byte b) {
        if (b > 0 && b < values().length) {
            return values()[b];
        }
        return Unknown;
    }

}
