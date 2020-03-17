package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 20:15
 * @Description:  事件
 */
public abstract class Event<T> {
    /**
     * 事件源对象
     * @return
     */
    abstract T getSource();
}
