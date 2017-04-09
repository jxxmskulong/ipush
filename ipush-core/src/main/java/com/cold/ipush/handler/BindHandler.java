package com.cold.ipush.handler;

import com.cold.ipush.protocol.Packet;
import com.cold.ipush.Request;
import com.cold.ipush.router.RouterCenter;
import io.netty.util.CharsetUtil;


/**
 * Created by faker on 2017/4/8.
 */
public class BindHandler extends BaseMessageHandler<String>{
    @Override
    public String decodeBody(Packet packet) {
        return new String(packet.body, CharsetUtil.UTF_8);
    }

    @Override
    public void handle(String body, Request request) {
        long userId = Long.parseLong(body);
        boolean success = RouterCenter.INSTANCE.publish(userId, request.getConnection());
        request.getResponse().send(new byte[]{success ? (byte) 1 : (byte) 0});
    }
}
