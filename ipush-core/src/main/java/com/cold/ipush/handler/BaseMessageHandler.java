package com.cold.ipush.handler;

import com.cold.ipush.MessageHandler;
import com.cold.ipush.Packet;
import com.cold.ipush.Request;

/**
 * Created by faker on 2017/4/8.
 */
public abstract class BaseMessageHandler<T> implements MessageHandler{

    @Override
    public void handle(Request request) {
    }

    public abstract T decodeBody(Packet packet);

    public abstract void handle(T t, Request request);
}
