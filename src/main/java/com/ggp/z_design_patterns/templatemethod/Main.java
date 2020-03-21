package com.ggp.z_design_patterns.templatemethod;

/**
 * @Author:GGP
 * @Date:2020/3/21 23:22
 * @Description:
 * 模板方法又叫钩子函数
 * 父类的实现方法中 会固定调用几个方法，这些方法会被子类重写或实现，完成被调用
 */
public class Main {
    public static void main(String[] args) {
        Listenter listenter = new KeyListener();
        listenter.invoke();
    }
}
