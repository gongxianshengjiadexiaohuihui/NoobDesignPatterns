package com.ggp.design_patterns.stategy;

/**
 * @Author:GGP
 * @Date:2020/3/12 21:03
 * @Description:
 */
public interface Comparator<T> {
    /**
     * 比较策略
     * @param t1
     * @param t2
     * @return
     */
    int compare(T t1,T t2);
}
