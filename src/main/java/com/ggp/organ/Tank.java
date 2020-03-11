package com.ggp.organ;

import com.ggp.common.Constant;
import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.view.TankFrame;

import java.awt.*;
import java.util.Random;

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
    private boolean moving = true;
    /**
     * 坦克是否存活
     */
    private boolean living = true;
    /**
     * 持有tankFrame的对象
     */
    private TankFrame tankFrame;
    /**
     * 属于那方,默认蓝方
     */
    private Group group = Group.BLUE;

    private Random random = new Random();
    /**
     * 坦克宽高
     */
    public static Integer weight = SourceManager.redTankD.getWidth();
    public static Integer height = SourceManager.redTankD.getHeight();
    /**
     * 区域
     */
    public Rectangle rectangle = new Rectangle();

    public Tank(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = weight;
        rectangle.width = height;
    }

    public void paint(Graphics g) {
        if (!living) {
            this.tankFrame.getEnemyTanks().remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(this.group == Group.RED ? SourceManager.redTankL : SourceManager.blueTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.RED ? SourceManager.redTankR : SourceManager.blueTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.RED ? SourceManager.redTankU : SourceManager.blueTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.RED ? SourceManager.redTankD : SourceManager.blueTankD, x, y, null);
                break;
            default:
                break;
        }
        this.move();
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
        /**
         * 更新区域
         */
        rectangle.x = x;
        rectangle.y = y;

        if (this.group == Group.BLUE && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BLUE) {
            this.rotateDir();
        }
        this.boundsCheck();
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if (this.x < 0) {
            this.x = 0;
        }
        /**
         * 30是菜单的长度
         */
        if (this.y < 30) {
            this.y = 30;
        }
        if (this.x > Constant.GAME_WIDTH - weight) {
            this.x = Constant.GAME_WIDTH - weight;
        }
        if (this.y > Constant.GAME_HEIGHT - height) {
            this.y = Constant.GAME_HEIGHT - height;
        }
    }

    /**
     * 旋转方向
     */
    private void rotateDir() {
        if (random.nextInt(100) > 95) {
            this.dir = DirectionEnum.values()[random.nextInt(4)];
        }
    }

    public void die() {
        living = false;
    }

    /**
     * 发射子弹
     */
    public void fire() {
        int bulletX = 0, bulletY = 0;
        switch (dir) {
            case UP:
                bulletX = this.x + Tank.weight / 2 - Bullet.weight / 2;
                bulletY = this.y - Bullet.height;
                break;
            case DOWN:
                bulletX = this.x + Tank.weight / 2 - Bullet.weight / 2;
                bulletY = this.y + Tank.height;
                break;
            case LFFT:
                bulletX = this.x - Bullet.weight;
                bulletY = this.y + Tank.weight / 2 - Bullet.weight / 2;
                break;
            case RIGHT:
                bulletX = this.x + Tank.weight;
                bulletY = this.y + Tank.weight / 2 - Bullet.weight / 2;
                break;
            default:
                break;
        }

        tankFrame.getBullets().add(new Bullet(bulletX, bulletY, this.dir, this.tankFrame, this.group));
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
