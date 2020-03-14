package com.ggp.z_design_patterns.factory.springbeanfactory;

/**
 * @Author:GGP
 * @Date:2020/3/14 23:28
 * @Description:
 */
public class Car {
    Driver d;
    public void print(){
        d.print();
    }

    public void setD(Driver d) {
        this.d = d;
    }
}
