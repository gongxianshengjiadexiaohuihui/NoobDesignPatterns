package com.ggp.z_design_patterns.factory.factoryMethod;

import com.ggp.z_design_patterns.factory.Car;
import com.ggp.z_design_patterns.factory.Moveable;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:58
 * @Description:
 */
public class CarFactory {
    public Moveable create(){
        /**
         * 前置处理
         */
        return new Car();
        /**
         * 后置处理
         */
    }
}
