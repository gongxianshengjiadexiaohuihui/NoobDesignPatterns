package com.ggp.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author:GGP
 * @Date:2020/3/28 16:05
 * @Description:
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 如果有客户端连接进来就放进channelGroup里
         */
        Server.INSTANCE.clients.add(ctx.channel());
        ServerFrame.INSTANCE.append("有新的客户端连接："+ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] result = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(result);
        /**
         * 收到消息就转发给所有客户端
         */
        ServerFrame.INSTANCE.append("客户端："+ctx.channel()+":发送消息:"+ new String(result));
        Server.INSTANCE.clients.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Server.INSTANCE.clients.remove(ctx.channel());
        ctx.channel().close();
        ServerFrame.INSTANCE.append("失去客户端连接："+ctx.channel());
    }
}
