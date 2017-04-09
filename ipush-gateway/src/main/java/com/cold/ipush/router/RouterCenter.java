package com.cold.ipush.router;

import com.cold.ipush.Connection;

/**
 * Created by faker on 2017/4/8.
 */
public class RouterCenter {

    public static final RouterCenter INSTANCE = new RouterCenter();

    private LocalRouterManager localRouterManager = new LocalRouterManager();
    private RemoteRouterManager remoteRouterManager = new RemoteRouterManager();

    public boolean publish(long userId, Connection connection) {
        localRouterManager.publish(userId, new LocalRouter(connection));
        remoteRouterManager.publish(userId, new RemoteRouter(new RouterInfo("127.0.0.1")));
        return true;
    }
}
