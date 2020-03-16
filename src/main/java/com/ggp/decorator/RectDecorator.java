package com.ggp.decorator;

import com.ggp.base.GameObject;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/16 21:11
 * @Description:
 */
public class RectDecorator extends GameObjectDecorator {
    public RectDecorator(GameObject object) {
        super(object);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Color c =g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(this.object.x,this.object.y,this.object.weight,this.object.height);
        g.setColor(c);
    }
}
