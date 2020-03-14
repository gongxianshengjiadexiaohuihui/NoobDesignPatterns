package com.ggp.organ;

import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.factory.BaseBullet;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 16:06
 * @Description:
 */
public class SunBullet extends BaseBullet {

    public SunBullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
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
         * 添加子弹
         */
        this.tankFrame.getBullets().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            this.tankFrame.getBullets().remove(this);
        }
        switch (dir) {
            case LFFT:
                g.drawImage(SourceManager.sunBulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SourceManager.sunBulletR, x, y, null);
                break;
            case UP:
                g.drawImage(SourceManager.sunBulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SourceManager.sunBulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

}
