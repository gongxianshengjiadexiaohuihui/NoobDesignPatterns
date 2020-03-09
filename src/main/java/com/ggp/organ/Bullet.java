package com.ggp.organ;

import com.ggp.common.ConstantCommand;
import com.ggp.common.DirectionEnum;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:34
 * @Description:
 */
public class Bullet {
    /**
     * 子弹坐标
     */
    private int x,y;
    /**
     * 子弹方向
     */
    private DirectionEnum dir;
    /**
     * 子弹半径
     */
    private static final int r = 30;
    /**
     * 子弹是否存活
     */
    private boolean live = true;
    /**
     * 持有主界面对象
     */
    private TankFrame tankFrame;
    public Bullet(int x, int y, DirectionEnum dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    public void paint(Graphics g){
        if(!live){
            this.tankFrame.getBullets().remove(this);
        }
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
        if(x<0 || y < 0 || x>ConstantCommand.GAME_WIDTH||y<ConstantCommand.GAME_HEIGHT){
            live = false;
        }
    }
}
