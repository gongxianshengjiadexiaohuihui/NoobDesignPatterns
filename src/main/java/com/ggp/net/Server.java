package com.ggp.net;

import com.ggp.common.Constant;
import com.ggp.net.message.MessageDecoder;
import com.ggp.net.message.MessageEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetSocketAddress;

/**
 * @Author:GGP
 * @Date:2020/3/28 16:00
 * @Description:
 */
public class Server {
    public static Server INSTANCE =  new Server();
    private Server(){}
    /**
     * 用来保存接入的客户端
     */
    public ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static void start(){
        EventLoopGroup acceptor= new NioEventLoopGroup(1);
        EventLoopGroup worker= new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(acceptor,worker);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new MessageEncoder());
                ch.pipeline().addLast(new MessageDecoder());
                ch.pipeline().addLast(new ServerHandler());
            }

        });
        try {
            ChannelFuture future = serverBootstrap.bind(new InetSocketAddress(Constant.DEFFAULT_PORT)).sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        ServerFrame.INSTANCE.append("服务端启动成功，端口号为："+Constant.DEFFAULT_PORT);
                    }else {
                        ServerFrame.INSTANCE.append("服务端启动失败");
                    }
                }
            });
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
    }
}
