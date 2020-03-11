package com.ggp.common;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:GGP
 * @Date:2020/3/10 19:25
 * @Description:
 */
public class SourceManager {
    /**
     * 蓝方坦克图片资源
     */
    public static BufferedImage redTankL, redTankR, redTankU, redTankD;
    /**
     * 红方坦克图片资源
     */
    public static BufferedImage blueTankL, blueTankR, blueTankU, blueTankD;
    /**
     * 子弹资源
     */
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;

    /**
     * 坦克爆炸效果
     */
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            blueTankU = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/BlueTank.png"));
            blueTankR = rotateImage(blueTankU,90);
            blueTankL = rotateImage(blueTankU,-90);
            blueTankD = rotateImage(blueTankU,180);

            redTankU = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/move/RedTank.png"));
            redTankR = rotateImage(redTankU,90);
            redTankL = rotateImage(redTankU,-90);
            redTankD = rotateImage(redTankU,180);

            bulletU = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bullet.png"));
            bulletD = rotateImage(bulletU,180);
            bulletL = rotateImage(bulletU,-90);
            bulletR = rotateImage(bulletU,90);

            for (int i = 0; i < explodes.length; i++) {
                explodes[i] = ImageIO.read(SourceManager.class.getClassLoader().getResourceAsStream("images/tank/explode/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 旋转图片
     *
     * @param image  图片资源
     * @param degree 旋转角度
     * @return
     */
    private static BufferedImage rotateImage(BufferedImage image, int degree) {
        int w = image.getWidth();
        int h = image.getHeight();
        int type = image.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(image, 0, 0, null);
        graphics2d.dispose();
        return img;

    }
}
