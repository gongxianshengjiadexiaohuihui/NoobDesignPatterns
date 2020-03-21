package com.ggp.z_design_patterns.command;

/**
 * @Author:GGP
 * @Date:2020/3/21 22:44
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Content content = new Content("test");
        Command command = new CopyCommand(content);
        command.doit();
        System.out.println(content.str);
        command.undo();
        System.out.println(content.str);

        command = new DeleteCommand(content);
        command.doit();
        System.out.println(content.str);
        command.undo();
        System.out.println(content.str);
    }
}
