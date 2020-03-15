package com.ggp.gamefactory;

import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.base.BaseBullet;
import com.ggp.base.BaseExplode;
import com.ggp.base.BaseTank;
import com.ggp.source.ImageManager;
import com.ggp.organ.sun_type.SunBullet;
import com.ggp.organ.sun_type.SunExplode;
import com.ggp.organ.sun_type.SunTank;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:36
 * @Description:
 */
public class SunGameFactory extends GameFactory {

    public SunGameFactory() {
        this.tankWeight = ImageManager.sunTankD.getWidth();
        this.tankHeight = ImageManager.sunTankD.getHeight();

        this.bulletWeight = ImageManager.sunBulletD.getWidth();
        this.bulletHeight = ImageManager.sunBulletD.getHeight();

        this.explodeWeight = ImageManager.sunExplodes[0].getWidth();
        this.explodeHeight = ImageManager.sunExplodes[0].getHeight();
    }

    @Override
    public BaseTank createTank(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        return new SunTank(x,y,dir, groupEnum);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new SunExplode(x,y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        return new SunBullet(x,y,dir, groupEnum);
    }
}
