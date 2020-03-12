package com.ggp.design_patterns.singleton;

import java.lang.reflect.Constructor;

/**
 * @Author:GGP
 * @Date:2020/3/12 19:41
 * @Description:
 */
public class LazySingletonC {
    private LazySingletonC(){}

    /**
     * JVM加载外部类的时候不会加载内部类，只要在调用内部类的时候，才会加载，而且JVM加载类的时候只会加载一次
     */
    private static class Internal{
        private final static LazySingletonC INSTANCE = new LazySingletonC();
    }
    public static LazySingletonC getInstance(){
        return Internal.INSTANCE;
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                System.out.println(LazySingletonC.getInstance().hashCode());
            }).start();
        }
        /**
         * 无法防止序列化
         */
        LazySingletonC instance1 = LazySingletonC.getInstance();
        Constructor<LazySingletonC> constructor =  LazySingletonC.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingletonC instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);
    }
}
