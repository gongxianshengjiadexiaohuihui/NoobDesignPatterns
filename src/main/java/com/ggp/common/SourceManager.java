package com.ggp.common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:GGP
 * @Date:2020/3/10 19:25
 * @Description:
 */
public class SourceManager {
    /**
     * 坦克图片资源
     */
    public static BufferedImage tankL, tankR, tankU, tankD;

    /**
     * 子弹资源
     */
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;

    /**
     * 坦克爆炸效果
     */
    public static BufferedImage[] explodes= new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/tankL.gif"));
            tankR = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/tankR.gif"));
            tankU = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/tankU.gif"));
            tankD = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/tankD.gif"));

            bulletL = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bulletL.gif"));
            bulletR = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bulletR.gif"));
            bulletU = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bulletU.gif"));
            bulletD = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bulletD.gif"));

            for (int i = 0; i < explodes.length ; i++) {
                explodes[i] =ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/explode/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
