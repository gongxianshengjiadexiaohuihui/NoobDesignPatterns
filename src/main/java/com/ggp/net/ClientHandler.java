package com.ggp.net;

import com.ggp.common.Config;
import com.ggp.net.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @Author:GGP
 * @Date:2020/3/28 16:36
 * @Description:
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message= (Message)msg;
        if(message.getId().equals(Config.gameModel.getMainTank().id)){
            return;
        }
        System.out.println("客户端收到的消息为："+msg);
        message.handle();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("退出！");
        ctx.channel().close();
    }
}
