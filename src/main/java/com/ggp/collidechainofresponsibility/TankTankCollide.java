package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;
import com.ggp.common.enums.DirectionEnum;

/**
 * @Author:GGP
 * @Date:2020/3/16 18:58
 * @Description: 坦克和坦克的碰撞
 */
public class TankTankCollide implements Collide{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof BaseTank && o2 instanceof BaseTank){
            BaseTank tank1 = (BaseTank) o1;
            BaseTank tank2 = (BaseTank) o2;
            tank1.collideWith(tank2);
            /**
             * 相同阵营，交换方向
             */
            if(tank1.groupEnum == tank2.groupEnum) {
                if (tank1.rectangle.intersects(tank2.rectangle)) {
                    DirectionEnum temp = tank2.dir;
                    tank2.dir = tank1.dir;
                    tank1.dir = temp;
                }
            }else{
                //todo
            }
        }

    }
}
