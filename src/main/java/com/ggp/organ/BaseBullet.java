package com.ggp.organ;

import com.ggp.common.Config;
import com.ggp.common.Constant;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.modefacade.GameModel;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:12
 * @Description:
 */
public abstract class BaseBullet {
    /**
     * 子弹坐标
     */
    public int x, y;
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
    public void collideWith(BaseTank tank) {
        /**
         * 判断子弹是否击中坦克
         */
        if (this.groupEnum == tank.groupEnum) {
            return;
        }
        if (this.rectangle.intersects(tank.rectangle)) {
            this.die();
            tank.die();
            int ex,ey;
            ex = tank.x + weight/2 - Config.gameFactory.explodeWeight/2;
            ey = tank.y + height/2 - Config.gameFactory.explodeHeight/2;
            Config.gameModel.explodes.add(Config.gameFactory.createExplode(ex,ey));
        }
    }

    protected void die() {
        living =false;
    }

    /**
     * 绘制
     * @param g
     */
   public  abstract void paint(Graphics g);
}
