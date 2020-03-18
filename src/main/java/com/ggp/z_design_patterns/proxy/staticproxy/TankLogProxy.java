package com.ggp.z_design_patterns.proxy.staticproxy;


/**
 * @Author:GGP
 * @Date:2020/3/18 19:26
 * @Description:
 */
public class TankLogProxy implements Movable {
    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("start move");
        movable.move();
        System.out.println("stop move");
    }
}
