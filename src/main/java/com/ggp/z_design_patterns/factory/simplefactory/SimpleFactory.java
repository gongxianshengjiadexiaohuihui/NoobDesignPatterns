package com.ggp.z_design_patterns.factory.simplefactory;

import com.ggp.z_design_patterns.factory.Car;
import com.ggp.z_design_patterns.factory.Plane;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:54
 * @Description:简单工厂
 *   可扩展性不好
 */
public class SimpleFactory {
    public Car createCar(){
        /**
         * 前置处理
         */
        return new Car();
        /**
         * 后置处理
         */
    }
    public Plane createPlane(){
        /**
         * 前置处理
         */
        return new Plane();
        /**
         * 后置处理
         */
    }
}
