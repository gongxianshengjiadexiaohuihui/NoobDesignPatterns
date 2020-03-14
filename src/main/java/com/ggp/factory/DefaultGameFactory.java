package com.ggp.factory;

import com.ggp.common.DirectionEnum;
import com.ggp.common.Group;
import com.ggp.common.SourceManager;
import com.ggp.organ.Bullet;
import com.ggp.organ.Explode;
import com.ggp.organ.Tank;
import com.ggp.view.TankFrame;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:14
 * @Description:
 */
public class DefaultGameFactory extends GameFactory {

    public DefaultGameFactory() {

        this.tankWeight = SourceManager.TankD.getWidth();
        this.tankHeight = SourceManager.TankD.getHeight();

        this.bulletWeight = SourceManager.defaultBulletD.getWidth();
        this.bulletHeight = SourceManager.defaultBulletD.getHeight();

        this.explodeWeight = SourceManager.defaultExplodes[0].getWidth();
        this.explodeHeight = SourceManager.defaultExplodes[0].getHeight();
    }

    @Override
    public BaseTank createTank(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        return new Tank(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, Group group) {
        return new Bullet(x, y, dir, tankFrame, group);
    }
}
