package com.ggp.fire;

import com.ggp.common.Audio;
import com.ggp.common.Group;
import com.ggp.organ.Bullet;
import com.ggp.organ.Tank;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:01
 * @Description: 默认开火策略 发射一颗子弹
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = 0, bulletY = 0;
        switch (tank.getDir()) {
            case UP:
                bulletX = tank.getX() + Tank.weight / 2 - Bullet.weight / 2;
                bulletY = tank.getY()- Bullet.height;
                break;
            case DOWN:
                bulletX = tank.getX() + Tank.weight / 2 - Bullet.weight / 2;
                bulletY = tank.getY() + Tank.height;
                break;
            case LFFT:
                bulletX = tank.getX() - Bullet.weight;
                bulletY = tank.getY() + Tank.weight / 2 - Bullet.weight / 2;
                break;
            case RIGHT:
                bulletX = tank.getX() + Tank.weight;
                bulletY = tank.getY() + Tank.weight / 2 - Bullet.weight / 2;
                break;
            default:
                break;
        }
       new Bullet(bulletX, bulletY, tank.getDir(), tank.getTankFrame(), tank.getGroup());
        /**
         * 红方坦克开火声音
         */
        if(tank.getGroup() == Group.RED){
            new Thread(()->{
                new Audio("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
