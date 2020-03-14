package com.ggp.organ;

import com.ggp.common.Config;
import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.factory.BaseBullet;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/9 21:34
 * @Description:
 */
public class Bullet extends BaseBullet {

    public Bullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width =weight;
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
                g.drawImage(SourceManager.defaultBulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SourceManager.defaultBulletR, x, y, null);
                break;
            case UP:
                g.drawImage(SourceManager.defaultBulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SourceManager.defaultBulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }



}
