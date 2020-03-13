package com.ggp.z_design_patterns.factory.factoryMethod;

import com.ggp.z_design_patterns.factory.Moveable;
import com.ggp.z_design_patterns.factory.Plane;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:59
 * @Description:
 */
public class PlaneFactory {
    public Moveable create(){
        /**
         * 前置处理
         */
        return new Plane();
        /**
         * 后置处理
         */
    }
}
