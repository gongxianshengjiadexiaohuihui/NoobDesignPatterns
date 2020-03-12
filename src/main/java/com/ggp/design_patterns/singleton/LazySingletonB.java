package com.ggp.design_patterns.singleton;

/**
 * @Author:GGP
 * @Date:2020/3/12 19:14
 * @Description: 懒汉 单例
 */
public class LazySingletonB {
    /**
     * 加volatile的原因 是
     * jvm在优化的时候会进行指令重排，volatile能够防止指令重排
     */
    private static volatile LazySingletonB INSTANCE ;
    private LazySingletonB(){

    }
    public static LazySingletonB getInstance(){
        /**
         * 第一个判断
         */
        if (null == INSTANCE) {
            /**在没有第二个判断的情况下
             * 如果第一个线程进来，还没获取锁，第二个线程进来拿到了锁，初始化完对像后释放锁，
             * 第一个线程拿到锁，又重新new对象 ，所以需要第二个判断
             */
            synchronized (LazySingletonB.class) {
                /**
                 * 第二个判断
                 */
                if(null == INSTANCE){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new LazySingletonB();
                }
            }
        }
        return INSTANCE;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                System.out.println(LazySingletonB.getInstance().hashCode());
            }).start();
        }
    }
}
