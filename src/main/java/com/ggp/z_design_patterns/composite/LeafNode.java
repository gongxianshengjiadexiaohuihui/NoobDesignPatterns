package com.ggp.z_design_patterns.composite;

/**
 * @Author:GGP
 * @Date:2020/3/17 21:05
 * @Description: 叶子节点
 */
public class LeafNode extends Node {
    public String name;

    public LeafNode(String name) {
        this.name = name;
    }

    @Override
    void print() {
        System.out.print(name);
    }
}
