package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:20
 * @Description:
 */
public class ReadyState extends ThreadState {
    public ReadyState(Thread thread) {
        this.thread=thread;
    }

    @Override
    void move(Action action) {
        if(action.msg.equals("ready_is_over")){
            thread.state=new RunningState(thread);
        }
    }

    @Override
    void run() {
        System.out.println("ready");
    }
}
