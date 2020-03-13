package com.ggp.z_design_patterns.factory.abstractfactory;

/**
 * @Author:GGP
 * @Date:2020/3/13 22:29
 * @Description:
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
