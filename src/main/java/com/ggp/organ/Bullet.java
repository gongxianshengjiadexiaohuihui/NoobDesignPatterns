package com.ggp.organ;

import com.ggp.common.ConstantCommand;
import com.ggp.common.DirectionEnum;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:34
 * @Description:
 */
public class Bullet {
    private int x,y;
    private DirectionEnum dir;

    private static final int r = 30;

    public Bullet(int x, int y, DirectionEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,r,r);
        /**
         * 还原画笔颜色
         */
        g.setColor(color);
        move();
    }
    /**
     * 子弹移动
     */
    private void move(){
        switch (dir) {
            case LFFT:
                x -= ConstantCommand.BULLET_SPEED;
                break;
            case RIGHT:
                x += ConstantCommand.BULLET_SPEED;
                break;
            case UP:
                y -=ConstantCommand.BULLET_SPEED;
                break;
            case DOWN:
                y += ConstantCommand.BULLET_SPEED;
                break;
            default:
                break;
        }
    }
}
