package com.ggp.z_design_patterns.proxy.staticproxy;

/**
 * @Author:GGP
 * @Date:2020/3/18 19:22
 * @Description:
 */
public class TankTimeProxy implements Movable {
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }
}
