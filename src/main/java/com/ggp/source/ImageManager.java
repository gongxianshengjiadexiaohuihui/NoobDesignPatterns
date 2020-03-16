package com.ggp.source;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:GGP
 * @Date:2020/3/10 19:25
 * @Description:
 */
public class ImageManager {
    /**
     * 坦克默认图片资源
     */
    public static BufferedImage TankL, TankR, TankU, TankD;
    /**
     * 坦克sun图片资源
     */
    public static BufferedImage sunTankL, sunTankR, sunTankU, sunTankD;
    /**
     * 敌人坦克图片资源
     */
    public static BufferedImage enemyTankL, enemyTankR, enemyTankU, enemyTankD;

    /**
     * 子弹默认图片资源
     */
    public static BufferedImage defaultBulletL, defaultBulletR, defaultBulletU, defaultBulletD;
    /**
     * 子弹sun类型图片资源
     */
    public static BufferedImage sunBulletL, sunBulletR, sunBulletU, sunBulletD;


    /**
     * 坦克默认爆炸效果
     */
    public static BufferedImage[] defaultExplodes = new BufferedImage[16];
    /**
     * 坦克sun爆炸效果
     */
    public static BufferedImage[] sunExplodes = new BufferedImage[11];

    /**
     * 墙的图片资源
     */
    public static BufferedImage wall;

    static {
        try {
            enemyTankU = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/tank/move/enemyTank.png"));
            enemyTankR = rotateImage(enemyTankU, 90);
            enemyTankL = rotateImage(enemyTankU, -90);
            enemyTankD = rotateImage(enemyTankU, 180);

            TankU = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/tank/move/tank.png"));
            TankR = rotateImage(TankU, 90);
            TankL = rotateImage(TankU, -90);
            TankD = rotateImage(TankU, 180);

            sunTankU = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/tank/move/sunTank.png"));
            sunTankR = rotateImage(sunTankU, 90);
            sunTankL = rotateImage(sunTankU, -90);
            sunTankD = rotateImage(sunTankU, 180);

            defaultBulletU = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/bullet/move/bullet.png"));
            defaultBulletD = rotateImage(defaultBulletU, 180);
            defaultBulletL = rotateImage(defaultBulletU, -90);
            defaultBulletR = rotateImage(defaultBulletU, 90);

            sunBulletR = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/bullet/move/sunBullet.png"));
            sunBulletL = rotateImage(sunBulletR, 180);
            sunBulletD = rotateImage(sunBulletR, 90);
            sunBulletU = rotateImage(sunBulletR, -90);

            for (int i = 0; i < defaultExplodes.length; i++) {
                defaultExplodes[i] = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/tank/explode/e" + (i + 1) + ".gif"));
            }
            for (int i = 0; i < sunExplodes.length; i++) {
                sunExplodes[i] = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/tank/explode/" + i + ".gif"));
            }

            wall = ImageIO.read(ImageManager.class.getClassLoader().getResourceAsStream("images/wall/wall.jpg"));
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
