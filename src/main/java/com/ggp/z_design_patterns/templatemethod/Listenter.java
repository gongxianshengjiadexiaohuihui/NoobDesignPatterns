package com.ggp.z_design_patterns.templatemethod;

/**
 * @Author:GGP
 * @Date:2020/3/21 23:19
 * @Description:
 */
public abstract class Listenter {
    void invoke(){
        method1();
        method2();
    }
    abstract void method1();
    abstract void method2();
}
