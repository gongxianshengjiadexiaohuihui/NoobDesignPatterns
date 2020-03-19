package com.ggp.z_design_patterns.visitor;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:53
 * @Description:   多用于编译器，解析xml文件
 */
public interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
