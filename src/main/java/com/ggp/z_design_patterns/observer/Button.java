package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 19:47
 * @Description:
 */
public class Button extends Observed{

    public void click(){
        super.notice(new ButtonClickEvent(this));
    }
    /**
     * 回调方法
     */
    public void callBack(){
        System.out.println("test callback");
    }
}
