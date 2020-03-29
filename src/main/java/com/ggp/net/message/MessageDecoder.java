package com.ggp.net.message;

import com.ggp.common.enums.MessageTypeEnum;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/28 22:50
 * @Description:
 */
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        /**
         * 消息头的消息类型和消息长度占8个字节
         */
        if (in.readableBytes() < 8) {
            return;
        }
        /**
         * 标记写的位置
         */
        in.markReaderIndex();
        MessageTypeEnum type = MessageTypeEnum.values()[in.readInt()];
        int len = in.readInt();
        if (in.readableBytes() < len) {
            in.resetReaderIndex();
            return;
        }
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        Message message = null;
        switch (type) {
            case TANK_JOIN:
                message = new TankJoinMessage();
                break;
            case TANK_STOP:
                message = new TankStopMessage();
                break;
            default:
                throw new RuntimeException("不支持的消息类型:" + type);
        }
        message.parse(bytes);
        out.add(message);
    }
}
