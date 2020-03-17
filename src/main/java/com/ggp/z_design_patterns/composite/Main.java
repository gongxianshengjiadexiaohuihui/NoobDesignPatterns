package com.ggp.z_design_patterns.composite;

/**
 * @Author:GGP
 * @Date:2020/3/17 21:09
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        LeafNode node1 = new LeafNode("C1");
        LeafNode node2 = new LeafNode("C2");
        LeafNode node3 = new LeafNode("C3");
        LeafNode node4 = new LeafNode("C4");

        BranchNode node5 = new BranchNode("B5");
        BranchNode node6 = new BranchNode("B6");

        node5.add(node1);
        node5.add(node2);
        node6.add(node3);
        node6.add(node4);

        BranchNode node = new BranchNode("ROOT");
        node.add(node5);
        node.add(node6);

        print(node,0);

    }

    public static void print(Node node, int dep){
        for (int i = 0; i <dep ; i++) {
            System.out.print("-");
        }
        node.print();
        System.out.println("");
        if(node instanceof BranchNode){
            for(Node node1:((BranchNode) node).nodes){
                print(node1,dep+1);
            }
        }
    }
}
