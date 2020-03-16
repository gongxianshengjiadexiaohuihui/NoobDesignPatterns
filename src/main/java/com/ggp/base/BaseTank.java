package com.ggp.base;

import com.ggp.common.*;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.firestrategy.DefaultFireStrategy;
import com.ggp.firestrategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:11
 * @Description:
 */
public abstract class BaseTank extends GameObject{
    /**
     * 坦克方向
     */
    public DirectionEnum dir;
    /**
     * 坦克是否移动
     */
    public boolean moving = true;
    /**
     * 坦克是否存活
     */
    public boolean living = true;
    /**
     * 属于那方,默认蓝方
     */
    public GroupEnum groupEnum = GroupEnum.BLUE;

    public Random random = new Random();
    /**
     * 图片大小
     */
    public int weight = Config.gameFactory.tankWeight;
    public int height = Config.gameFactory.tankHeight;
    /**
     * 区域
     */
    public Rectangle rectangle = new Rectangle();

    /**
     * 开火策略  默认策略
     */
    public FireStrategy fireStrategy = new DefaultFireStrategy();


    /**
     * 坦克移动
     */
    protected void move() {
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

        if (this.groupEnum == GroupEnum.BLUE && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.groupEnum == GroupEnum.BLUE) {
            this.rotateDir();
        }
        this.boundsCheck();
    }

    /**
     * 边界检测
     */
    protected void boundsCheck() {
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
     * 碰撞检测
     * @param tank
     */
    public void collideWith(BaseTank tank) {

    }

    /**
     * 旋转方向
     */
    protected void rotateDir() {
        if (random.nextInt(100) > 95) {
            this.dir = DirectionEnum.values()[random.nextInt(4)];
        }
    }

    public void die() {
        this.living = false;
    }


    /**
     * 发射子弹
     */
    public void fire() {
        fireStrategy.fire(this);
    }
}
