package com.ggp.view;

import com.ggp.common.Config;
import com.ggp.common.Constant;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.modefacade.GameModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:GGP
 * @Date:2020/3/9 19:32
 * @Description:
 */
public class GameFrame extends Frame {
   
    public GameModel model = Config.gameModel;

    public GameFrame() {
        /**
         * 页面属性
         */
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("Tank war");
        this.setVisible(true);
        /**
         * 监听键盘
         */
        this.addKeyListener(new KeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
      model.paint(g);
    }

    /**
     * 双缓冲解决闪烁问题
     * 闪烁问题，画图比较慢小于屏幕的刷新率
     * 在内存中先生成一张图片，把内容画在图片上，画完之后在画到屏幕上
     */
    Image image = null;

    @Override
    public void update(Graphics g) {
        if (null == image) {
            image = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics screen = image.getGraphics();
        Color color = screen.getColor();
        screen.setColor(Color.BLACK);
        screen.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        screen.setColor(color);
        paint(screen);
        g.drawImage(image, 0, 0, null);
    }

    /**
     * 键盘监听处理类
     */
    class KeyListener extends KeyAdapter {
        /**
         * 判断坦克的方向
         */
        boolean isL = false;
        boolean isR = false;
        boolean isU = false;
        boolean isD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    isL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    isR = true;
                    break;
                case KeyEvent.VK_UP:
                    isU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    isD = true;
                    break;
                default:
                    break;
            }
            setDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    isL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    isR = false;
                    break;
                case KeyEvent.VK_UP:
                    isU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    isD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    model.getMainTank().fire();
                    break;
                case KeyEvent.VK_S:
                    model.save();
                    break;
                case KeyEvent.VK_V:
                    model.recover();
                    model = Config.gameModel;
                    break;
                default:
                    break;
            }
            setDirection();
        }

        private void setDirection() {
            /**
             * 判断是否移动
             */
            if (!isL && !isR && !isU && !isD) {
                model.getMainTank().moving = false;
            } else {
                model.getMainTank().moving = true;
            }
            /**
             * 判断方向
             */
            if (isL) {
                model.getMainTank().dir = DirectionEnum.LFFT;
            }
            if (isR) {
                model.getMainTank().dir = DirectionEnum.RIGHT;
            }
            if (isU) {
                model.getMainTank().dir = DirectionEnum.UP;
            }
            if (isD) {
                model.getMainTank().dir = DirectionEnum.DOWN;
            }

        }
    }

}
