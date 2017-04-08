package com.cold.ipush;

import com.cold.ipush.handler.BindHandler;
import com.cold.ipush.handler.LoginHandler;

/**
 * Created by faker on 2017/4/8.
 */
public class MessageReceiver implements Receiver{

    private MessageHandler handler = new LoginHandler();
    private BindHandler bindHandler = new BindHandler();

    @Override
    public void onMessage(Request request) {
        switch (request.getCommand()) {
            case Heartbeat:
                break;
            case Handshake:
                break;
            case Login:
                handler.handle(request);
                break;
            case Bind:
                bindHandler.handle(request);
                break;
            case Kick:
                break;
            case Unknown:
                break;
        }
    }
}
