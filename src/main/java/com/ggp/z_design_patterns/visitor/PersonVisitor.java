package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 22:03
 * @Description:
 */
public class PersonVisitor implements Visitor {
    double totalPrice = 0;
    @Override
    public void visitCpu(CPU cpu) {
        totalPrice+=cpu.getPrice()*2;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice+=memory.getPrice()*2;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice+=board.getPrice()*2;
    }
}
