package com.cold.ipush.router;

import com.cold.ipush.Router;
import com.cold.ipush.RouterManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by faker on 2017/4/8.
 */
public class LocalRouterManager implements RouterManager{

    private final Map<Long, Router> routerMap =new ConcurrentHashMap<>();

    @Override
    public boolean publish(long userId, Router route) {
        routerMap.put(userId, route);
        return true;
    }

    @Override
    public boolean unPublish(long userId) {
        routerMap.remove(userId);
        return true;
    }

    @Override
    public Router getRouter(long userId) {
        return routerMap.get(userId);
    }
}
