package com.ggp.z_design_patterns.proxy.staticproxy;

/**
 * @Author:GGP
 * @Date:2020/3/18 19:23
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------");
        TankTimeProxy tankTimeProxy = new TankTimeProxy(new Tank());
        tankTimeProxy.move();
        System.out.println("---------------");
        TankLogProxy tankLogProxy = new TankLogProxy(tankTimeProxy);
        tankLogProxy.move();
    }
}
