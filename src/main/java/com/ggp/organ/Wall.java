package com.ggp.organ;

import com.ggp.base.GameObject;
import com.ggp.source.ImageManager;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/16 20:16
 * @Description:
 */
public class Wall extends GameObject {
    /**
     * 区域
     */
    public Rectangle rectangle = new Rectangle();
    /**
     * 图片宽高
     */
    public int weight = ImageManager.wall.getWidth();
    public int height = ImageManager.wall.getHeight();

    public Wall(int x, int y){
        this.x = x;
        this.y = y;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = weight;
        rectangle.height = height;
    }
    @Override
    public void paint(Graphics g) {
       g.drawImage(ImageManager.wall,x,y,null);
    }
}
