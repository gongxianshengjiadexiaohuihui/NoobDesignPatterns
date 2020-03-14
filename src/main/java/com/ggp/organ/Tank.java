package com.ggp.organ;

import com.ggp.common.*;
import com.ggp.factory.BaseTank;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:08
 * @Description:
 */
public class Tank extends BaseTank {
    public Tank(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
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
                g.drawImage(this.group == Group.RED ? SourceManager.TankL : SourceManager.enemyTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.RED ? SourceManager.TankR : SourceManager.enemyTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.RED ? SourceManager.TankU : SourceManager.enemyTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.RED ? SourceManager.TankD : SourceManager.enemyTankD, x, y, null);
                break;
            default:
                break;
        }
        this.move();
    }

}
