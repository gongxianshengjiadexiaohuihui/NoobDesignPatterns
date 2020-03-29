package com.ggp.net.message;

import com.ggp.base.BaseTank;
import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.common.enums.MessageTypeEnum;
import com.ggp.modefacade.GameModel;

import java.io.*;
import java.util.UUID;

/**
 * @Author:GGP
 * @Date:2020/3/28 18:38
 * @Description:
 */
public class TankJoinMessage extends Message {
    private int x;
    private int y;
    private DirectionEnum dir;
    private GroupEnum group;
    private String name;

    public TankJoinMessage(){}
    public TankJoinMessage(BaseTank tank) {
        this.x = tank.x;
        this.y = tank.y;
        this.dir = tank.dir;
        this.group = tank.groupEnum;
        this.name = tank.name;
        this.id=tank.id;
    }


    @Override
    public void handle() {
        BaseTank  tank =Config.gameFactory.createTank(this.x,this.y,this.dir,this.group);
        tank.name= this.name;
        GameModel.getInstance().add(tank);
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
            dos.writeInt(this.x);
            dos.writeInt(this.y);
            dos.writeInt(this.dir.ordinal());
            dos.writeInt(this.group.ordinal());
            dos.writeUTF(this.name);
            dos.writeLong(this.id.getMostSignificantBits());
            dos.writeLong(this.id.getLeastSignificantBits());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    @Override
    public void parse(byte[] bytes) {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        try {
            this.x = dis.readInt();
            this.y = dis.readInt();
            this.dir = DirectionEnum.values()[dis.readInt()];
            this.group = GroupEnum.values()[dis.readInt()];
            this.name = dis.readUTF();
            this.id = new UUID(dis.readLong(),dis.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public MessageTypeEnum getType() {
        return MessageTypeEnum.TANK_JOIN;
    }

    @Override
    public String toString() {
        return "TankJoinMessage{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", group=" + group +
                ", name='" + name + '\'' +
                '}';
    }
}
