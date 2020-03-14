package com.ggp.z_design_patterns.factory.springbeanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:GGP
 * @Date:2020/3/14 23:19
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        /**
         * IOC inverse of control  横向扩展
         * DI  dependent insect   纵向扩展
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Driver driver  = (Driver) context.getBean("driver");
        driver.print();

        Car car = (Car)context.getBean("car");
        car.print();
    }
}
