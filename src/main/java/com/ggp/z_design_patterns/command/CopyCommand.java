package com.ggp.z_design_patterns.command;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:42
 * @Description:
 */
public class CopyCommand implements Command{
    Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doit() {
        content.str = content.str+content.str;
    }

    @Override
    public void undo() {
        content.str = content.str.substring(0,content.str.length()/2);
    }
}
