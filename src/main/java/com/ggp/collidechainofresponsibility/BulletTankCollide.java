package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseBullet;
import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;

/**
 * @Author:GGP
 * @Date:2020/3/15 23:29
 * @Description:
 */
public class BulletTankCollide implements Collide {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof BaseBullet && o2 instanceof BaseTank){
            BaseTank tank = (BaseTank)o2;
            BaseBullet bullet = (BaseBullet)o1;
            bullet.collideWith(tank);
        }else if( o1 instanceof BaseTank && o2 instanceof BaseBullet){
            this.collide(o2,o1);
        }else {
            return;
        }
    }
}
