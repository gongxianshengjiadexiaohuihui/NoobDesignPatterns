package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:24
 * @Description:
 */
public class RunningState extends ThreadState{
    public RunningState(Thread thread) {
        this.thread=thread;
    }

    @Override
    void move(Action action) {
        if(action.msg.equals("running_is_over")){
            this.thread.state=new NewState(thread);
        }
    }

    @Override
    void run() {
        System.out.println("running");
    }
}
