package com.ggp.collidechainofresponsibility;

import com.ggp.base.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/16 19:23
 * @Description:  碰撞链   几个单个检测可以合并成链，几个链也可以合并成链，
 * 如果是链就会递归调用接口  妙呀！！！！
 */
public class CollideChain implements Collide{
    private List<Collide> collides = new LinkedList<>();
    public CollideChain(){
        add(new BulletTankCollide());
        add(new TankTankCollide());
    }
    public void add(Collide collide){
        collides.add(collide);
    }


    @Override
    public void collide(GameObject o1, GameObject o2) {
        for (Collide collide : collides){
            collide.collide(o1,o2);
        }
    }
}
