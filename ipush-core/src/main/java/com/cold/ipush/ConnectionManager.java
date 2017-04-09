package com.cold.ipush;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import io.netty.channel.Channel;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectionManager {
    public static final ConnectionManager INSTANCE = new ConnectionManager();

    //可能会有20w的链接数
    private final ConcurrentMap<String, Connection> connections = new ConcurrentHashMapV8<>();

    public Connection get(final String channelId) throws ExecutionException {
        return connections.get(channelId);
    }

    public Connection get(final Channel channel){
        return connections.get(channel.toString());
    }

    public void add(Connection connection) {
        connections.putIfAbsent(connection.getId(), connection);
    }

    public void add(Channel channel){
        Connection connection = new NettyConnection();
        connection.init(channel);
        connections.putIfAbsent(connection.getId(), connection);
    }

    public void remove(Connection connection) {
        connections.remove(connection.getId());
    }

    public void remove(Channel channel){
        connections.remove(channel.toString());
    }

    public List<String> getConnectionIds(){
        return new ArrayList<>(connections.keySet());
    }

    public List<Connection> getConnections(){
        return new ArrayList<>(connections.values());
    }
}
