package com.ggp.organ;

import com.ggp.common.Constant;
import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
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
    private int x, y;
    /**
     * 子弹方向
     */
    private DirectionEnum dir;
    /**
     * 子弹是否存活
     */
    private boolean living = true;
    /**
     * 持有主界面对象
     */
    private TankFrame tankFrame;
    /**
     * 子弹属于那方
     */
    private Group group = Group.BLUE;
    /**
     * 子弹的宽高
     */
    public static Integer weight = SourceManager.bulletD.getWidth();
    public static Integer height = SourceManager.bulletD.getHeight();


    public Bullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            this.tankFrame.getBullets().remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(SourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SourceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(SourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SourceManager.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    /**
     * 子弹移动
     */
    private void move() {
        switch (dir) {
            case LFFT:
                x -= Constant.BULLET_SPEED;
                break;
            case RIGHT:
                x += Constant.BULLET_SPEED;
                break;
            case UP:
                y -= Constant.BULLET_SPEED;
                break;
            case DOWN:
                y += Constant.BULLET_SPEED;
                break;
            default:
                break;
        }
       check();
    }
    private void check(){
        /**
         * 边界值
         */
        if (x < 0 || y < 0 || x > Constant.GAME_WIDTH || y > Constant.GAME_HEIGHT) {
            living = false;
        }

    }
    public void collideWith(Tank tank) {
        /**
         * 判断子弹是否击中坦克
         */
        if (tank.getGroup() == this.getGroup()) {
            return;
        }
        if (new Rectangle(tank.getX(), tank.getY(), Tank.weight, Tank.height).intersects(new Rectangle(x, y, weight, height))) {
            this.die();
            tank.die();
            tankFrame.getExplodes().add(new Explode(x,y,tankFrame));
        }
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

    public void die() {
        living =false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
