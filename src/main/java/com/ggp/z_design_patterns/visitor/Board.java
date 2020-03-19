package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:58
 * @Description:
 */
public class Board  extends ComputerPart{
    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
