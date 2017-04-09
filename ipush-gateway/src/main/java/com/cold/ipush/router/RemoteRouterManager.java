package com.cold.ipush.router;

/**
 * Created by faker on 2017/4/8.
 */
public class RemoteRouterManager implements RouterManager{
    @Override
    public boolean publish(long userId, Router route) {
        return false;
    }

    @Override
    public boolean unPublish(long userId) {
        return false;
    }

    @Override
    public Router getRouter(long userId) {
        return null;
    }
}
