package com.ggp.z_design_patterns.singleton;


/**
 * @Author:GGP
 * @Date:2020/3/12 19:47
 * @Description:
 *   下面是 反编译结果
 *   public final class com.ggp.z_design_patterns.singleton.LazySingletonD extends java.lang.Enum<com.ggp.z_design_patterns.singleton.LazySingletonD> {
 *   public static final com.ggp.z_design_patterns.singleton.LazySingletonD INSTANCE;
 *   public static com.ggp.z_design_patterns.singleton.LazySingletonD[] values();
 *   public static com.ggp.z_design_patterns.singleton.LazySingletonD valueOf(java.lang.String);
 *   public static void main(java.lang.String[]) throws java.lang.Exception;
 *   static {};
 * }
 */
public enum  LazySingletonD {
    INSTANCE;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                System.out.println(LazySingletonD.INSTANCE.hashCode());
            }).start();
        }
    }
}
/**
 *
 */
