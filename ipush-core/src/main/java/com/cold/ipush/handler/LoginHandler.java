package com.cold.ipush.handler;

import com.cold.ipush.LoginMessage;
import com.cold.ipush.protocol.Packet;
import com.cold.ipush.Request;

/**
 * Created by faker on 2017/4/8.
 */
public class LoginHandler extends BaseMessageHandler<LoginMessage>{

    @Override
    public LoginMessage decodeBody(Packet packet) {
        return new LoginMessage();
    }

    @Override
    public void handle(LoginMessage message, Request request) {
        request.getResponse().send("login success".getBytes());
    }
}
