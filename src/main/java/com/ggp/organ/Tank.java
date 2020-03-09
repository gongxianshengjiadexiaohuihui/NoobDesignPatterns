package com.ggp.organ;

import com.ggp.common.ConstantCommand;
import com.ggp.common.DirectionEnum;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:08
 * @Description:
 */
public class Tank {
    /**
     * 坦克坐标
     */
    private int x,y;
    /**
     * 坦克方向
     */
    private DirectionEnum dir = DirectionEnum.DOWN;
    /**
     * 坦克是否移动
     */
    private boolean moving = false;
    public Tank(int x, int y, DirectionEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    /**
     * 坦克移动
     */
    private void move(){
        if(!moving){
            return;
        }
        switch (dir) {
            case LFFT:
                x -= ConstantCommand.SPEED;
                break;
            case RIGHT:
                x += ConstantCommand.SPEED;
                break;
            case UP:
                y -= ConstantCommand.SPEED;
                break;
            case DOWN:
                y += ConstantCommand.SPEED;
                break;
            default:
                break;
        }
    }

    public void setDir(DirectionEnum dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
