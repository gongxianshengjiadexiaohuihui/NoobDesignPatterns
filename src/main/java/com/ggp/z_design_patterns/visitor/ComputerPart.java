package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:54
 * @Description:
 */
public abstract class ComputerPart {
    abstract void accept(Visitor visitor);
    abstract double getPrice();
}
