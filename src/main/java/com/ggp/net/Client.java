package com.ggp.net;

import com.ggp.common.Constant;
import com.ggp.net.message.Message;
import com.ggp.net.message.MessageDecoder;
import com.ggp.net.message.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author:GGP
 * @Date:2020/3/28 16:30
 * @Description:
 */
public class Client {
    public static Client INSTANCE= new Client();
    private Channel channel;
    public  void connect(){
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(worker);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {

                ch.pipeline().addLast(new MessageEncoder());
                ch.pipeline().addLast(new MessageDecoder());
                ch.pipeline().addLast(new ClientHandler());
            }
        });
        try {
            ChannelFuture future =bootstrap.connect(new InetSocketAddress(Constant.DEFAULT_IP,Constant.DEFFAULT_PORT)).sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("客户端连接成功");
                        Client.INSTANCE.channel =future.channel();
                    }
                }
            });
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(Message message){
        channel.writeAndFlush(message);
    }

}
