package com.ggp.factory;

import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:12
 * @Description:
 */
public abstract class BaseExplode {
    /**
     * 坐标
     */
    protected int x, y;
    /**
     * 持有对象
     */
    protected TankFrame tankFrame;
    /**
     * 记录步数
     */
    protected Integer step = 0;
    /**
     * 绘制
     * @param g
     */
    public abstract void paint(Graphics g);
}
