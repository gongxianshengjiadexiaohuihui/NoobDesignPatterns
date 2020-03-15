package com.ggp.organ;

import com.ggp.common.Config;
import com.ggp.modefacade.GameModel;

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
     * 记录步数
     */
    protected Integer step = 0;
    /**
     * 绘制
     * @param g
     */
    public abstract void paint(Graphics g);
}
