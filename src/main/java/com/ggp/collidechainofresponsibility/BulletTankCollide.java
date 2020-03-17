package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseBullet;
import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;
import com.ggp.common.Config;
import com.ggp.decorator.GameObjectDecorator;

/**
 * @Author:GGP
 * @Date:2020/3/15 23:29
 * @Description: 子弹和坦克的碰撞
 */
public class BulletTankCollide implements Collide {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        removeDecorator(o1);
        removeDecorator(o2);

        if(o1 instanceof BaseBullet && o2 instanceof BaseTank){
            BaseTank tank = (BaseTank)o2;
            BaseBullet bullet = (BaseBullet)o1;
            /**
             * 判断子弹是否击中坦克
             */
            if (bullet.groupEnum == tank.groupEnum) {
                return;
            }
            if (bullet.rectangle.intersects(tank.rectangle)) {
                bullet.die();
                tank.die();
                //todo 加个绘制策略 区分多种风格的爆炸
                int ex,ey;
                ex = tank.x + tank.weight/2 - Config.gameFactory.explodeWeight/2;
                ey = tank.y + tank.height/2 - Config.gameFactory.explodeHeight/2;
                Config.gameModel.add(Config.gameFactory.createExplode(ex,ey));
            }
        }else if( o1 instanceof BaseTank && o2 instanceof BaseBullet){
            this.collide(o2,o1);
        }else {
            return;
        }
    }

    //todo  未生效
    /**
     * 判断前去除装饰器
     * @param obj
     */
    private void removeDecorator(Object obj){
        if(!(obj instanceof GameObjectDecorator)){
            return ;
        }else{
            removeDecorator(((GameObjectDecorator) obj).object);
        }
    }
}
