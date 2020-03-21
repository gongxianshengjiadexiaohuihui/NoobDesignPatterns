package com.ggp.z_design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/21 22:35
 * @Description:
 */
public class DeleteCommand implements Command {
    Content content;
    List<Content> deleted = new ArrayList<>();
    int index = -1;

    public DeleteCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doit() {
        try {
            deleted.add((Content) content.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        index++;
        content.str = "";
    }

    @Override
    public void undo() {
        content.str = content.str + deleted.get(index).str;
        index--;
    }
}
