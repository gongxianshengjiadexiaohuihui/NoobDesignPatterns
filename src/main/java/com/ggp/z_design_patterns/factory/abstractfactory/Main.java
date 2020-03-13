package com.ggp.z_design_patterns.factory.abstractfactory;

/**
 * @Author:GGP
 * @Date:2020/3/13 21:47
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new MagicFactory();
        factory.createFood().eat();
        factory.createVehicle().go();
        factory.createWeapon().shoot();

        factory = new MagicFactory();
        factory.createFood().eat();
        factory.createVehicle().go();
        factory.createWeapon().shoot();
    }
}
