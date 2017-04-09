package com.cold.ipush.router;

import com.cold.ipush.Connection;

/**
 * Created by faker on 2017/4/8.
 */
public class RemoteRouter implements Router{
    private final RouterInfo routerInfo;

    public RemoteRouter(RouterInfo routerInfo) {
        this.routerInfo = routerInfo;
    }

    @Override
    public Connection getConnect() {
        return null;
    }

    @Override
    public RouterInfo getRouterInfo() {
        return null;
    }
}
