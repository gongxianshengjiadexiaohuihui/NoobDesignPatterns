package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:14
 * @Description:
 */
public abstract class ThreadState {
    protected Thread thread;
    /**
     * 线程状态迁移
     * @param action
     */
    abstract void move(Action action);

    /**
     * 该状态下执行动作
     */
    abstract void run();
}
