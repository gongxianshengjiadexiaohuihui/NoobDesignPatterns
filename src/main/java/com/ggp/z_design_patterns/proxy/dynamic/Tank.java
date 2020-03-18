package com.ggp.z_design_patterns.proxy.dynamic;

import java.util.Random;

/**
 * @Author:GGP
 * @Date:2020/3/18 19:18
 * @Description:
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank move ba ba ba ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
