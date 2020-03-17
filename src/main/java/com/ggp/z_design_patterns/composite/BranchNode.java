package com.ggp.z_design_patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/17 21:08
 * @Description:
 */
public class BranchNode extends Node{
    public String name;
    public List<Node> nodes = new ArrayList<>();
    public BranchNode(String name) {
        this.name = name;
    }
    public void add(Node node){
        this.nodes.add(node);
    }

    @Override
    void print() {
        System.out.print(name);
    }
}
