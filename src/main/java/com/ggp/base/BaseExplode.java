package com.ggp.base;

import com.ggp.common.Config;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:12
 * @Description:
 */
public abstract class BaseExplode extends GameObject{
    /**
     * 记录步数
     */
    protected Integer step = 0;
    public BaseExplode(){
        weight = Config.gameFactory.explodeWeight;
        height = Config.gameFactory.explodeHeight;
    }
}
