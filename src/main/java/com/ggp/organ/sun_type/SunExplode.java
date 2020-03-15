package com.ggp.organ.sun_type;

import com.ggp.common.Config;
import com.ggp.source.ImageManager;
import com.ggp.base.BaseExplode;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:24
 * @Description:
 */
public class SunExplode extends BaseExplode {

    public SunExplode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageManager.sunExplodes[step++], this.x, this.y, null);
        if (step >= ImageManager.sunExplodes.length) {
            Config.gameModel.remove(this);
        }
    }
}
