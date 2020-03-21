package com.ggp.z_design_patterns.command;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:41
 * @Description:
 */
public class Content implements Cloneable {
    String str;

    public Content(String str) {
        this.str = str;
    }

    @Override
    public  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
