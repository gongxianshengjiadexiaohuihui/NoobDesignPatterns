package com.ggp.z_design_patterns.proxy.dynamic.jdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:GGP
 * @Date:2020/3/18 19:43
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 保存 生成代理类文件
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Tank tank = new Tank();
        Movable proxy =(Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            /**
             * @param proxy   代理对象，不是被代理对象，可能在一个方法中用到另一个对象！
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("start");
                Object o = method.invoke(tank);
                System.out.println("stop");
                return o;
            }
        });
        proxy.move();
    }
}
/**
 * //
 * // Source code recreated from a .class file by IntelliJ IDEA
 * // (powered by Fernflower decompiler)
 * //
 *
 * package com.sun.proxy;
 *
 * import com.ggp.z_design_patterns.proxy.dynamic.jdk.Movable;
 * import java.lang.reflect.InvocationHandler;
 * import java.lang.reflect.Method;
 * import java.lang.reflect.Proxy;
 * import java.lang.reflect.UndeclaredThrowableException;
 *
 * public final class $Proxy0 extends Proxy implements Movable {
 *     private static Method m1;
 *     private static Method m3;
 *     private static Method m2;
 *     private static Method m0;
 *
 *     public $Proxy0(InvocationHandler var1) throws  {
 *         super(var1);
 *     }
 *
 *     public final boolean equals(Object var1) throws  {
 *         try {
 *             return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
 *         } catch (RuntimeException | Error var3) {
 *             throw var3;
 *         } catch (Throwable var4) {
 *             throw new UndeclaredThrowableException(var4);
 *         }
 *     }
 *
 *     public final void move() throws  {
 *         try {
 *             super.h.invoke(this, m3, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final String toString() throws  {
 *         try {
 *             return (String)super.h.invoke(this, m2, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final int hashCode() throws  {
 *         try {
 *             return (Integer)super.h.invoke(this, m0, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     static {
 *         try {
 *             m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
 *             m3 = Class.forName("com.ggp.z_design_patterns.proxy.dynamic.jdk.Movable").getMethod("move");
 *             m2 = Class.forName("java.lang.Object").getMethod("toString");
 *             m0 = Class.forName("java.lang.Object").getMethod("hashCode");
 *         } catch (NoSuchMethodException var2) {
 *             throw new NoSuchMethodError(var2.getMessage());
 *         } catch (ClassNotFoundException var3) {
 *             throw new NoClassDefFoundError(var3.getMessage());
 *         }
 *     }
 * }
 */
