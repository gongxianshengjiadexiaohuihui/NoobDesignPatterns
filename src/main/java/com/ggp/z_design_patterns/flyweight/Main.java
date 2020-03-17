package com.ggp.z_design_patterns.flyweight;

/**
 * @Author:GGP
 * @Date:2020/3/17 21:23
 * @Description: 享元模式多用于各种池子
 */
public class Main {
    public static void main(String[] args) {


        /**
         * java 字符串都放在一个常量池里，所以当发现“abc”这个字符串先去常量池里面找，如果没有，会生成一个。如果有就会 返回它的引用
         */
        String s1 = "abc";
        String s2 = "abc";
        /**
         * 当new一个String时候，会在堆里创造一个对象，但是对象里指向“abc”的引用还是去常量池里面找，这个s3 s4是指向对象的引用，这个对象持有对“abc”的引用
         */
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1  == s3);
        System.out.println(s3  == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern());
        /***
         * 观察字节码可发现只有一个“abc”
         */

    }
}
