package com.cold.ipush.router;

import com.cold.ipush.Connection;

/**
 * Created by faker on 2017/4/8.
 */
public interface Router {
    Connection getConnect();

    RouterInfo getRouterInfo();
}
