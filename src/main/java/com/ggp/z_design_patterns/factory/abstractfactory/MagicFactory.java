package com.ggp.z_design_patterns.factory.abstractfactory;

/**
 * @Author:GGP
 * @Date:2020/3/13 22:30
 * @Description:
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
