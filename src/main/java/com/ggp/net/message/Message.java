package com.ggp.net.message;

import com.ggp.common.enums.MessageTypeEnum;

import java.util.UUID;

/**
 * @Author:GGP
 * @Date:2020/3/28 17:54
 * @Description:
 */
public abstract class Message {
    protected UUID id;

    /**
     * 收到此消息后进行的动作
     */
    public abstract void handle();

    /**
     * 转成字节数组
     * @return
     */
    public abstract byte[] toBytes();

    /**
     * 将字节数组转成对象
     */
    public abstract void parse(byte[] bytes);

    /**
     * 获取消息类型
     * @return
     */
    public abstract MessageTypeEnum getType();
}
