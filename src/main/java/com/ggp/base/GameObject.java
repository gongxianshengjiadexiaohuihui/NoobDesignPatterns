package com.ggp.base;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/15 22:59
 * @Description:  游戏物体的父类
 */
public abstract class GameObject {
    /**
     * 物体坐标
     */
    public int x,y;
    /**
     * 图片大小
     */
    public int weight ;
    public int height ;

    /**
     * 绘制物体
     * @param g
     */
    public abstract void paint(Graphics g);
}
