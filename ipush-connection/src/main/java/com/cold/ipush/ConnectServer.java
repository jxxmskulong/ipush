package com.cold.ipush;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by faker on 2017/4/8.
 */
public class ConnectServer implements Runnable{

    private int port;

    @Override
    public void run() {

        /*
        NioEventLoopGroup 是用来处理channel 的 io操作的多线程循环器，类似于NIO的 selector,
        一般会有两个group
        boss:用来接收连进来的连接
        worker:用来处理进来的连接
        当boss接收了连接，就会把连接注册到worker上
         */
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        // 用于启动NIO服务的辅助启动类，可以直接使用channel
        ServerBootstrap b = new ServerBootstrap();
        b.group(boss, worker);

        //NioServerSocketChannel 是基于NIO selector为基础实现的，用来接收新的连接
        //此方法主要用来声明创建channel的类别
        b.channel(NioServerSocketChannel.class);

        /*
        事件处理类主要用来处理最近接收的channel 事件
        ChannelInitializer是一个特殊的处理类，用来帮助使用者配置一个新的channel
        你可以添加各种channelHandler业务处理器到pipeline上
         */
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new PacketDecode());
                ch.pipeline().addLast(new PacketEncode());
                ch.pipeline().addLast(new ConnectionHandler());
            }
        });
        /*
        用来设置通道实现的配置参数，是提供给NioServerSocketChannel用来接收进来的连接
        请参考ChannelOption和详细的ChannelConfig实现的接口文档以此可以对ChannelOptions的有一个大概的认识
         */
        b.option(ChannelOption.SO_BACKLOG, 1024);
        /*
        是提供给由父管道ServerChannel接收到的连接,在这个例子中也是NioServerSocketChannel
         */
        b.childOption(ChannelOption.SO_KEEPALIVE, true);

        try {
            //绑定端口并启动去接收进来的连接
            ChannelFuture future = b.bind(port).sync();
            //同步等待socket关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
