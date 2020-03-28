package com.ggp.organ.sun_type;

import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.source.ImageManager;
import com.ggp.base.BaseTank;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 16:58
 * @Description:
 */
public class SunTank extends BaseTank {
    public SunTank(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.groupEnum = groupEnum;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = weight;
        rectangle.height = height;
        /**
         * 红方坦克开火策略从配置文件读取
         */
        if(groupEnum == GroupEnum.RED){
            fireStrategy = Config.getFireStrategy();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            Config.gameModel.remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage( ImageManager.sunTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage( ImageManager.sunTankR , x, y, null);
                break;
            case UP:
                g.drawImage( ImageManager.sunTankU , x, y, null);
                break;
            case DOWN:
                g.drawImage( ImageManager.sunTankD , x, y, null);
                break;
            default:
                break;
        }
        Color color = g.getColor();
        g.setColor(Color.yellow);
        /**
         * 一个字符占7个像素
         */
        g.drawString(this.name,x+Config.gameFactory.tankWeight/2-this.name.length()*7/2,y);
        g.setColor(color);
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
