package com.cold.ipush;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectionManager {
    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private Map<String, Connection> connections = new ConcurrentHashMap<>();

    public Connection get(String channelId) {
        return connections.get(channelId);
    }

    public void add(Connection connection) {
        connections.put(connection.getId(), connection);
    }

    public void remove(Connection connection) {
        connections.remove(connection.getId());
    }
}
