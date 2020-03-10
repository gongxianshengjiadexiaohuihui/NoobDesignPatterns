package com.ggp.organ;

import com.ggp.common.Constant;
import com.ggp.common.DirectionEnum;
import com.ggp.common.SourceManager;
import com.ggp.view.TankFrame;

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
    private int x, y;
    /**
     * 坦克方向
     */
    private DirectionEnum dir;
    /**
     * 坦克是否移动
     */
    private boolean moving = false;
    /**
     * 坦克是否存活
     */
    private boolean living = true;
    /**
     * 持有tankFrame的对象
     */
    private TankFrame tankFrame;
    /**
     * 坦克宽高
     */
    public static Integer weight = SourceManager.tankD.getWidth();
    public static Integer height = SourceManager.tankD.getHeight();

    public Tank(int x, int y, DirectionEnum dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if(!living){
            this.tankFrame.getEnemyTanks().remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(SourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SourceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(SourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SourceManager.tankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    /**
     * 坦克移动
     */
    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LFFT:
                x -= Constant.TANK_SPEED;
                break;
            case RIGHT:
                x += Constant.TANK_SPEED;
                break;
            case UP:
                y -= Constant.TANK_SPEED;
                break;
            case DOWN:
                y += Constant.TANK_SPEED;
                break;
            default:
                break;
        }
    }



    public void die() {
        living=false;
    }

    /**
     * 发射子弹
     */
    public void fire() {
        int bulletX = 0, bulletY = 0;
        /**
         * 坐标后面加的数是因为图片尺寸产生的修正值，为了看起来子弹是从坦克炮管中射出来
         */
        switch (dir) {
            case UP:
                bulletX = this.x + Tank.weight / 2 - Bullet.weight / 2 + 2;
                bulletY = this.y - Bullet.height;
                break;
            case DOWN:
                bulletX = this.x + Tank.weight / 2 - Bullet.weight / 2 - 1;
                bulletY = this.y + Tank.height;
                break;
            case LFFT:
                bulletX = this.x - Bullet.weight;
                bulletY = this.y + Tank.weight / 2 - Bullet.weight / 2 + 2;
                break;
            case RIGHT:
                bulletX = this.x + Tank.weight;
                bulletY = this.y + Tank.weight / 2 - Bullet.weight / 2 + 4;
                break;
            default:
                break;
        }

        tankFrame.getBullets().add(new Bullet(bulletX, bulletY, this.dir, this.tankFrame));
    }

    public void setDir(DirectionEnum dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
