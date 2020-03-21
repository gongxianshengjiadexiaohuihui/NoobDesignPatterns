package com.ggp.z_design_patterns.command;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:36
 * @Description:
 */
public interface Command {
    /**
     * 执行
     */
    void doit();

    /**
     * 回退
     */
    void undo();
}
