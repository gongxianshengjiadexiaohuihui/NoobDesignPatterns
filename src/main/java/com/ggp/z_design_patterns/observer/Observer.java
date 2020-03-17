package com.ggp.z_design_patterns.observer;

/**
 * @Author:GGP
 * @Date:2020/3/17 20:14
 * @Description:
 */
public interface Observer {
    /**
     * 处理事件
     * @param e
     */
    void deal(Event e);
}
