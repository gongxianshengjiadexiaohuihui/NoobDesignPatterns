package com.ggp.net.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author:GGP
 * @Date:2020/3/28 21:11
 * @Description:
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        /**
         * 写入类型
         */
        out.writeInt(msg.getType().ordinal());
        /**
         * 写入数据长度
         */
        out.writeInt(msg.toBytes().length);
        /**
         * 写入数据
         */
        out.writeBytes(msg.toBytes());
    }
}
