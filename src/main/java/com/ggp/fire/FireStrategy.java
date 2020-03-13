package com.ggp.fire;

import com.ggp.organ.Tank;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:00
 * @Description:
 */
public interface FireStrategy {
    /**
     * 开火策略
     * @param tank
     */
    void  fire(Tank tank);
}
