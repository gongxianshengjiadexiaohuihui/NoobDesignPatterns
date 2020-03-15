package com.ggp.firestategy;

import com.ggp.source.AudioManager;
import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.organ.BaseTank;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:21
 * @Description:
 */
public class FourFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int weightTank = Config.gameFactory.tankWeight;
        int heightTank = Config.gameFactory.tankHeight;
        int weightBullet = Config.gameFactory.bulletWeight;
        int heightBullet = Config.gameFactory.bulletHeight;
        
        int bulletX, bulletY;
        /**
         * 向上下左右发射子弹
         */
        bulletX = tank.x + weightTank / 2 - weightBullet / 2;
        bulletY = tank.y - heightBullet;
        Config.gameFactory.createBullet(bulletX, bulletY,DirectionEnum.UP, tank.groupEnum);

        bulletX = tank.x + weightTank / 2 - weightBullet / 2;
        bulletY = tank.y + heightTank;
        Config.gameFactory.createBullet(bulletX, bulletY, DirectionEnum.DOWN, tank.groupEnum);

        bulletX = tank.x - weightBullet;
        bulletY = tank.y + weightTank / 2 - heightBullet / 2;
        Config.gameFactory.createBullet(bulletX, bulletY, DirectionEnum.LFFT, tank.groupEnum);

        bulletX = tank.x + weightTank;
        bulletY = tank.y + weightTank / 2 - heightBullet / 2;
        Config.gameFactory.createBullet(bulletX, bulletY, DirectionEnum.RIGHT,  tank.groupEnum);
        /**
         * 红方坦克开火声音
         */
        if (tank.groupEnum == GroupEnum.RED) {
            new Thread(() -> {
                new AudioManager("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
