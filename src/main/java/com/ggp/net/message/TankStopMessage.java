package com.ggp.net.message;

import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;
import com.ggp.common.Config;
import com.ggp.common.enums.MessageTypeEnum;

import java.io.*;
import java.util.UUID;

/**
 * @Author:GGP
 * @Date:2020/3/29 18:23
 * @Description:
 */
public class TankStopMessage extends Message{
    private int x;
    private int y;
    private UUID id;
    public TankStopMessage(){}
    public TankStopMessage(BaseTank tank){
        this.x = tank.x;
        this.y = tank.y;
        this.id = tank.id;
    }
    @Override
    public void handle() {
        GameObject object = Config.gameModel.find(id);
        if(object instanceof BaseTank){
            BaseTank tank = (BaseTank)object;
            tank.x = x;
            tank.y =y;
            tank.moving = false;
        }
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream bos =  new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
            dos.writeInt(this.x);
            dos.writeInt(this.y);
            dos.writeLong(this.id.getMostSignificantBits());
            dos.writeLong(this.id.getLeastSignificantBits());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    @Override
    public void parse(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(bis);
        try {
            this.x = dis.readInt();
            this.y = dis.readInt();
            this.id = new UUID(dis.readLong(),dis.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MessageTypeEnum getType() {
        return MessageTypeEnum.TANK_STOP;
    }
}
