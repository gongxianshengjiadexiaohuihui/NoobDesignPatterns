package com.ggp.firestrategy;

import com.ggp.base.BaseTank;

import java.io.Serializable;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:00
 * @Description:
 */
public interface FireStrategy extends Serializable {
    /**
     * 开火策略
     * @param tank
     */
    void  fire(BaseTank tank);
}
