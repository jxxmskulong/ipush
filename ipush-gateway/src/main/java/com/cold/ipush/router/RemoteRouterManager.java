package com.cold.ipush.router;

import com.cold.ipush.Router;
import com.cold.ipush.RouterManager;

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
