package com.ggp.factory;

import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.organ.SunBullet;
import com.ggp.organ.SunExplode;
import com.ggp.organ.SunTank;
import com.ggp.view.TankFrame;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:36
 * @Description:
 */
public class SunGameFactory extends GameFactory {

    public SunGameFactory() {
        this.tankWeight = SourceManager.sunTankD.getWidth();
        this.tankHeight = SourceManager.sunTankD.getHeight();

        this.bulletWeight = SourceManager.sunBulletD.getWidth();
        this.bulletHeight = SourceManager.sunBulletD.getHeight();

        this.explodeWeight = SourceManager.sunExplodes[0].getWidth();
        this.explodeHeight = SourceManager.sunExplodes[0].getHeight();
    }

    @Override
    public BaseTank createTank(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        return new SunTank(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new SunExplode(x,y,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        return new SunBullet(x,y,dir,tankFrame,group);
    }
}
