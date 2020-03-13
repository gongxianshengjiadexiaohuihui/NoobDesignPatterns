package com.ggp.z_design_patterns.factory;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:47
 * @Description:
 */
public class Car implements Moveable{

    @Override
    public void go(){
        System.out.println("跑");
    }
}
