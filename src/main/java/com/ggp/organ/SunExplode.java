package com.ggp.organ;

import com.ggp.common.SourceManager;
import com.ggp.factory.BaseExplode;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:24
 * @Description:
 */
public class SunExplode extends BaseExplode {

    public SunExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(SourceManager.sunExplodes[step++], this.x, this.y, null);
        if (step >= SourceManager.sunExplodes.length) {
            tankFrame.getExplodes().remove(this);
        }
    }
}
