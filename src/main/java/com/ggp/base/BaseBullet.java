package com.ggp.base;

import com.ggp.common.Config;
import com.ggp.common.Constant;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:12
 * @Description:
 */
public abstract class BaseBullet extends GameObject{
    /**
     * 子弹方向
     */
    public DirectionEnum dir;
    /**
     * 子弹是否存活
     */
    public boolean living = true;
    /**
     * 子弹属于那方
     */
    public GroupEnum groupEnum = GroupEnum.BLUE;
    /**
     * 图片大小
     */
    public int weight = Config.gameFactory.bulletWeight;
    public int height = Config.gameFactory.bulletHeight;
    /**
     * 区域
     */
    public Rectangle rectangle = new Rectangle();
    /**
     * 子弹移动
     */
    protected void move() {
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
        /**
         * 更新区域
         */
        rectangle.x = x;
        rectangle.y = y;
    }
    protected void check(){
        /**
         * 边界值
         */
        if (x < 0 || y < 0 || x > Constant.GAME_WIDTH || y > Constant.GAME_HEIGHT) {
            living = false;
        }

    }

    public void die() {
        living =false;
    }


}
