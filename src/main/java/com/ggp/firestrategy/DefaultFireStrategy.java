package com.ggp.firestrategy;

import com.ggp.source.AudioManager;
import com.ggp.common.Config;
import com.ggp.common.enums.GroupEnum;
import com.ggp.base.BaseTank;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:01
 * @Description: 默认开火策略 发射一颗子弹
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int bulletX = 0, bulletY = 0;
        int weightTank = Config.gameFactory.tankWeight;
        int heightTank = Config.gameFactory.tankHeight;
        int weightBullet = Config.gameFactory.bulletWeight;
        int heightBullet = Config.gameFactory.bulletHeight;

        switch (tank.dir) {
            case UP:
                bulletX = tank.x + weightTank / 2 - weightBullet / 2;
                bulletY = tank.y - heightBullet;
                break;
            case DOWN:
                bulletX = tank.x + weightTank / 2 - weightBullet / 2;
                bulletY = tank.y + heightTank;
                break;
            case LFFT:
                bulletX = tank.x - weightBullet;
                bulletY = tank.y + weightTank / 2 - heightBullet / 2;
                break;
            case RIGHT:
                bulletX = tank.x + weightTank;
                bulletY = tank.y + weightTank / 2 - heightBullet / 2;
                break;
            default:
                break;
        }
       Config.gameFactory.createBullet(bulletX, bulletY, tank.dir, tank.groupEnum);
        /**
         * 红方坦克开火声音
         */
        if(tank.groupEnum == GroupEnum.RED){
            new Thread(()->{
                new AudioManager("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
