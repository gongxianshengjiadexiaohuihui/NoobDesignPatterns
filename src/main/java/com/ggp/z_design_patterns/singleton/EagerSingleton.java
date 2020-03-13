package com.ggp.z_design_patterns.singleton;

/**
 * @Author:GGP
 * @Date:2020/3/12 19:10
 * @Description: 饿汉 单例
 */
public class EagerSingleton {
    private static final EagerSingleton INSTANTCE = new EagerSingleton();
    private EagerSingleton(){
    }
    public static EagerSingleton getInstance(){
        return INSTANTCE;
    }
    public static void main(String[] args) {
        EagerSingleton mgr01 = EagerSingleton.getInstance();
        EagerSingleton mgr02 = EagerSingleton.getInstance();
        System.out.println(mgr01 == mgr02);
    }
}
