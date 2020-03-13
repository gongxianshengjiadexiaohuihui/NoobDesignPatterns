package com.ggp.z_design_patterns.factory.abstractfactory;

/**
 * @Author:GGP
 * @Date:2020/3/13 22:26
 * @Description:
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Vehicle createVehicle();

}
