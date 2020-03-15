package com.ggp.gamefactory;

import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.organ.BaseBullet;
import com.ggp.organ.BaseExplode;
import com.ggp.organ.BaseTank;
import com.ggp.source.ImageManager;
import com.ggp.organ.default_type.Bullet;
import com.ggp.organ.default_type.Explode;
import com.ggp.organ.default_type.Tank;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:14
 * @Description:
 */
public class DefaultGameFactory extends GameFactory {

    public DefaultGameFactory() {

        this.tankWeight = ImageManager.TankD.getWidth();
        this.tankHeight = ImageManager.TankD.getHeight();

        this.bulletWeight = ImageManager.defaultBulletD.getWidth();
        this.bulletHeight = ImageManager.defaultBulletD.getHeight();

        this.explodeWeight = ImageManager.defaultExplodes[0].getWidth();
        this.explodeHeight = ImageManager.defaultExplodes[0].getHeight();
    }

    @Override
    public BaseTank createTank(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        return new Tank(x,y,dir, groupEnum);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new Explode(x, y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirectionEnum dir, GroupEnum groupEnum) {
        return new Bullet(x, y, dir, groupEnum);
    }
}
