package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 20:26
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.add(new ButtonClickObserver());
        button.click();
    }
}
