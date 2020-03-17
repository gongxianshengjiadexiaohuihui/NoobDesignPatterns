package com.ggp.z_design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/17 19:48
 * @Description:被观察者
 */
public  class Observed {
    List<Observer>  observerList = new ArrayList<>();

    public void notice(Event e){
        for(Observer observer:observerList){
            observer.deal(e);
        }
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void add(Observer observer){
        this.observerList.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    public void remove(Observer observer){
        this.observerList.remove(observer);
    }
}
