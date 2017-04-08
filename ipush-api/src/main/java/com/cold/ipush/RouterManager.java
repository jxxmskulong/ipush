package com.cold.ipush;

/**
 * Created by faker on 2017/4/8.
 */
public interface RouterManager {
    boolean publish(long userId, Router route);

    boolean unPublish(long userId);

    Router getRouter(long userId);
}
