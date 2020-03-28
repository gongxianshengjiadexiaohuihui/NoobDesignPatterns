package com.ggp.net.message;

import com.ggp.base.BaseTank;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.common.enums.MessageTypeEnum;

import java.io.*;

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
    private boolean living;

    public TankJoinMessage(BaseTank tank) {
        this.x = tank.x;
        this.y = tank.y;
        this.dir = tank.dir;
        this.group = tank.groupEnum;
        this.living = tank.living;
    }

    @Override
    public void handle() {
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
            dos.writeBoolean(this.living);
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
            this.living = dis.readBoolean();
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
                ", living=" + living +
                '}';
    }
}
