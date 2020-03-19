package com.ggp.z_design_patterns.iterator;

/**
 * @Author:GGP
 * @Date:2020/3/19 19:49
 * @Description:
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
