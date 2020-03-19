package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:59
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        PersonVisitor visitor =  new PersonVisitor();
        computer.accept(visitor);
        System.out.println(visitor.totalPrice);
    }
}
