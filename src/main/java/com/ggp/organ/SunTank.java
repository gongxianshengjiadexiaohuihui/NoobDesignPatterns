package com.ggp.organ;

import com.ggp.common.Config;
import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.factory.BaseTank;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 16:58
 * @Description:
 */
public class SunTank extends BaseTank {
    public SunTank(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = weight;
        rectangle.height = height;
        /**
         * 红方坦克开火策略从配置文件读取
         */
        if(group  == Group.RED){
            fireStrategy = Config.getFireStrategy();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            this.tankFrame.getEnemyTanks().remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(this.group == Group.RED ? SourceManager.sunTankL : SourceManager.enemyTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.RED ? SourceManager.sunTankR : SourceManager.enemyTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.RED ? SourceManager.sunTankU : SourceManager.enemyTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.RED ? SourceManager.sunTankD : SourceManager.enemyTankD, x, y, null);
                break;
            default:
                break;
        }
        this.move();
    }
    /**
     * 发射子弹
     */
    @Override
    public void fire() {
        fireStrategy.fire(this);
    }
}
