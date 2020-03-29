package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseBullet;
import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;
import com.ggp.common.Config;
import com.ggp.common.enums.GroupEnum;
import com.ggp.decorator.GameObjectDecorator;

/**
 * @Author:GGP
 * @Date:2020/3/15 23:29
 * @Description: 子弹和坦克的碰撞
 */
public class BulletTankCollide implements Collide {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        o1 = removeDecorator(o1);
        o2 = removeDecorator(o2);

        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseTank tank = (BaseTank) o2;
            BaseBullet bullet = (BaseBullet) o1;
            /**
             * 判断子弹是否击中坦克 //暂时开启主站tank无敌
             */
            if (tank.groupEnum == GroupEnum.RED || bullet.groupEnum == tank.groupEnum) {
                return;
            }
            if (bullet.rectangle.intersects(tank.rectangle)) {
                bullet.die();
                tank.die();
                int ex, ey;
                ex = tank.x + tank.weight / 2 - Config.gameFactory.explodeWeight / 2;
                ey = tank.y + tank.height / 2 - Config.gameFactory.explodeHeight / 2;
                Config.gameModel.add(Config.gameFactory.createExplode(ex, ey));
            }
        } else if (o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            this.collide(o2, o1);
        } else {
            return;
        }
    }

    /**
     * 判断前去除装饰器
     *
     * @param obj
     */
    private GameObject removeDecorator(GameObject obj) {
        if (obj instanceof GameObjectDecorator) {
            obj = ((GameObjectDecorator) obj).object;
            removeDecorator(obj);
        }
        return obj;
    }
}
