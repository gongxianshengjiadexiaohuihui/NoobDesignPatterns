package com.ggp.fire;

import com.ggp.common.Audio;
import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.organ.Bullet;
import com.ggp.organ.Tank;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:21
 * @Description:
 */
public class FourFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX, bulletY;
        bulletX = tank.getX() + Tank.weight / 2 - Bullet.weight / 2;
        bulletY = tank.getY() - Bullet.height;
        new Bullet(bulletX, bulletY, DirectionEnum.UP, tank.getTankFrame(), tank.getGroup());
        bulletX = tank.getX() + Tank.weight / 2 - Bullet.weight / 2;
        bulletY = tank.getY() + Tank.height;
        new Bullet(bulletX, bulletY, DirectionEnum.DOWN, tank.getTankFrame(), tank.getGroup());
        bulletX = tank.getX() - Bullet.weight;
        bulletY = tank.getY() + Tank.weight / 2 - Bullet.weight / 2;
        new Bullet(bulletX, bulletY, DirectionEnum.LFFT, tank.getTankFrame(), tank.getGroup());
        bulletX = tank.getX() + Tank.weight;
        bulletY = tank.getY() + Tank.weight / 2 - Bullet.weight / 2;
        new Bullet(bulletX, bulletY, DirectionEnum.RIGHT, tank.getTankFrame(), tank.getGroup());
        /**
         * 红方坦克开火声音
         */
        if (tank.getGroup() == Group.RED) {
            new Thread(() -> {
                new Audio("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
