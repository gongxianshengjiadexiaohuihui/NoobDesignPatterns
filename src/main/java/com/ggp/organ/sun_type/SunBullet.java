package com.ggp.organ.sun_type;

import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.source.ImageManager;
import com.ggp.base.BaseBullet;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 16:06
 * @Description:
 */
public class SunBullet extends BaseBullet {

    public SunBullet(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.groupEnum = groupEnum;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = weight;
        rectangle.height = height;

        /**
         * 添加子弹
         */
        Config.gameModel.add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            Config.gameModel.remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(ImageManager.sunBulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ImageManager.sunBulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ImageManager.sunBulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ImageManager.sunBulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

}
