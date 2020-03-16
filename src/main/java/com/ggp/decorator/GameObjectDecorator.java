package com.ggp.decorator;

import com.ggp.base.GameObject;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/16 21:09
 * @Description:
 */
public class GameObjectDecorator extends GameObject {
    /**
     * 被装饰对象
     */
    public GameObject object;
    public GameObjectDecorator(GameObject object) {
        this.object = object;
    }

    @Override
    public void paint(Graphics g) {
        /**
         * 先画被装饰物品
         */
        object.paint(g);
    }
}
