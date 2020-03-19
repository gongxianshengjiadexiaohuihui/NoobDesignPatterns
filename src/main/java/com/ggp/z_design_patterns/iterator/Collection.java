package com.ggp.z_design_patterns.iterator;

/**
 * @Author:GGP
 * @Date:2020/3/19 19:48
 * @Description:
 */
public interface Collection<E> {
    void add(E e);
    Iterator<E> iterator();
}
