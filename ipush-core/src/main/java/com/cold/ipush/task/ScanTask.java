package com.cold.ipush.task;

import com.cold.ipush.NettyConnection;

/**
 * Created by faker on 2017/4/9.
 */
public interface ScanTask {
    public void visit(long now, NettyConnection client);
}
