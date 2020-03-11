package com.ggp.organ;

import com.ggp.common.SourceManager;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/10 22:45
 * @Description:
 */
public class Explode {
    /**
     * 爆炸图片宽高
     */
    public static Integer weight = SourceManager.explodes[0].getWidth();
    public static Integer height = SourceManager.explodes[0].getHeight();
    /**
     * 坐标
     */
    private int x, y;
    /**
     * 持有对象
     */
    private TankFrame tankFrame;
    private Integer step = 0;
    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics  g){

        g.drawImage(SourceManager.explodes[step++],this.x,this.y,null);
        if(step >= SourceManager.explodes.length ){
           tankFrame.getExplodes().remove(this);
        }
    }
}
