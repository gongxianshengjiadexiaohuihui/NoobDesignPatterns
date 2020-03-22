package com.ggp.z_design_patterns.state;

/**
 * @Author:GGP
 * @Date:2020/3/22 15:27
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Action action =new Action();
        Thread thread = new Thread();
        ThreadState state = new NewState(thread);
        thread.state=state;
        thread.run();
        action.msg="new_is_over";
        thread.move(action);
        thread.run();
        action.msg="ready_is_over";
        thread.move(action);
        thread.run();
        action.msg="running_is_over";
        thread.move(action);
        thread.run();
    }
}
