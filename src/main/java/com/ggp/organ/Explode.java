package com.ggp.organ;

import com.ggp.common.SourceManager;
import com.ggp.factory.BaseExplode;
import com.ggp.view.TankFrame;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/10 22:45
 * @Description:
 */
public class Explode extends BaseExplode {
    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(SourceManager.defaultExplodes[step++], this.x, this.y, null);
        if (step >= SourceManager.defaultExplodes.length) {
            tankFrame.getExplodes().remove(this);
        }
    }
}
