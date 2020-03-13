package com.ggp.z_design_patterns.singleton;

/**
 * @Author:GGP
 * @Date:2020/3/12 19:14
 * @Description: 懒汉 单例
 */
public class LazySingletonA {
    private static LazySingletonA INSTANCE ;
    private LazySingletonA(){

    }
    public static LazySingletonA getInstance(){
        /**
         * 第一步
         */
        if(null == INSTANCE){
            try {
                /**
                 * 如果不加延迟，第一步判断和第二步返回值，间隔太小无法模拟被其他线程打断
                 */
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazySingletonA();
        }
        /**
         * 第二步
         */
        return INSTANCE;
        /**
         * 在多线程情况下，第一步和第二步之间如果多个线程进来，就会返回不同对象
         */
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                System.out.println(LazySingletonA.getInstance().hashCode());
            }).start();
        }
    }
}
