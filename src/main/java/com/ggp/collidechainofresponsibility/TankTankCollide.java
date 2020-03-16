package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;

/**
 * @Author:GGP
 * @Date:2020/3/16 18:58
 * @Description:
 */
public class TankTankCollide implements Collide{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof BaseTank && o2 instanceof BaseTank){
            BaseTank tank1 = (BaseTank) o1;
            BaseTank tank2 = (BaseTank) o2;
            tank1.collideWith(tank2);
        }else {
            return;
        }
    }
}
