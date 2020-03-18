package com.ggp.z_design_patterns.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:GGP
 * @Date:2020/3/18 19:43
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("start");
                Object result = methodProxy.invokeSuper(o,objects);
                System.out.println("end");
                return result;
            }
        });
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}