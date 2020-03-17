package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 20:26
 * @Description:
 */
public class ButtonClickObserver implements Observer {
    @Override
    public void deal(Event e) {
        ((Button)e.getSource()).callBack();
    }
}
