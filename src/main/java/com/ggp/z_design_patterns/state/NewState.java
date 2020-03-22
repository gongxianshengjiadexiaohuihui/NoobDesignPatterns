package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:15
 * @Description:
 */
public class NewState extends ThreadState {

    public NewState(Thread thread) {
        this.thread = thread;
    }

    @Override
    void move(Action action) {
        if(action.msg.equals("new_is_over")){
            this.thread.state= new ReadyState(thread);
        }
    }

    @Override
    void run() {
        System.out.println("new");
    }
}
