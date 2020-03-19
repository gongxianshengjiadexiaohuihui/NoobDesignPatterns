package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:55
 * @Description:
 */
public class CPU extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
       return  500;
    }
}
