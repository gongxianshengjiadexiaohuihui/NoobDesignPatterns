package com.ggp.collidechainofresponsibility;

import com.ggp.base.GameObject;

import java.io.Serializable;

/**
 * @Author:GGP
 * @Date:2020/3/15 23:22
 * @Description:碰撞检测  责任链模式  策略模式
 */
public interface Collide extends Serializable {
    /**
     * 碰撞检测
     * @param o1
     * @param o2
     */
    void collide(GameObject o1,GameObject o2);
}
