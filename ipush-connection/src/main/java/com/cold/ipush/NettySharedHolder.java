package com.cold.ipush;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timer;

/**
 * Created by faker on 2017/4/9.
 */
public class NettySharedHolder {

    public static final Timer timer = new HashedWheelTimer(new ThreadFactoryBuilder().setNameFormat(Constants.NETTY_TIMER + "-%d").build());

    public static final ByteBufAllocator byteBufAllocator;

    static {
        byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
    }
}
