package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:17
 * @Description:
 */
public class Thread {
    public ThreadState state;

    public void move(Action action){
        state.move(action);
    }

    public void run(){
        state.run();
    }
}
