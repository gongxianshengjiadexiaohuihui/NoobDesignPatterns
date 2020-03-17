package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 20:19
 * @Description:
 */
public class ButtonClickEvent extends Event<Button> {
    public Button button;

    public ButtonClickEvent(Button button){
        this.button = button;
    }
    @Override
    Button getSource() {
        return button;
    }
}
