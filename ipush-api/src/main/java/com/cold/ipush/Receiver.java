package com.cold.ipush;

/**
 * Created by faker on 2017/4/8.
 */
public interface Receiver {

    void onMessage(Request request);
}
