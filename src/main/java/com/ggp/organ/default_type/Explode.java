package com.ggp.organ.default_type;

import com.ggp.common.Config;
import com.ggp.source.ImageManager;
import com.ggp.base.BaseExplode;

import java.awt.*;

/**
 * @Author:GGP
 * @Date:2020/3/10 22:45
 * @Description:
 */
public class Explode extends BaseExplode {
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageManager.defaultExplodes[step++], this.x, this.y, null);
        if (step >= ImageManager.defaultExplodes.length) {
            Config.gameModel.remove(this);
        }
    }
}
