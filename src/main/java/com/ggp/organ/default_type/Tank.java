package com.ggp.organ.default_type;

import com.ggp.common.*;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.base.BaseTank;
import com.ggp.source.ImageManager;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:08
 * @Description:
 */
public class Tank extends BaseTank {
    public Tank(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
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
                g.drawImage( ImageManager.TankL , x, y, null);
                break;
            case RIGHT:
                g.drawImage( ImageManager.TankR , x, y, null);
                break;
            case UP:
                g.drawImage( ImageManager.TankU , x, y, null);
                break;
            case DOWN:
                g.drawImage( ImageManager.TankD , x, y, null);
                break;
            default:
                break;
        }
        this.move();
    }

}
