package com.ggp.collidechainofresponsibility;

import com.ggp.base.BaseBullet;
import com.ggp.base.GameObject;
import com.ggp.organ.Wall;

/**
 * @Author:GGP
 * @Date:2020/3/16 20:41
 * @Description: 子弹和墙的碰撞
 */
public class BulletWallCollide implements Collide {

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof Wall) {
            BaseBullet bullet = (BaseBullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.rectangle.intersects(wall.rectangle)) {
                bullet.die();
            }
        } else if (o2 instanceof BaseBullet && o1 instanceof Wall) {
            this.collide(o2, o1);
        } else {
            return;
        }
    }
}
