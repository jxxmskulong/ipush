package com.cold.ipush.router;

import com.cold.ipush.Connection;

/**
 * Created by faker on 2017/4/8.
 */
public class LocalRouter implements Router{
    private final Connection connection;

    public LocalRouter(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnect() {
        return connection;
    }

    @Override
    public RouterInfo getRouterInfo() {
        return null;
    }
}
