package com.ggp.view;

import com.ggp.common.ConstantCommand;
import com.ggp.common.DirectionEnum;
import com.ggp.organ.Bullet;
import com.ggp.organ.Tank;

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
public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200, DirectionEnum.DOWN);
    Bullet bullet = new Bullet(250,250,DirectionEnum.DOWN);
    public TankFrame() {
        /**
         * 页面属性
         */
        this.setSize(800, 800);
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
        myTank.paint(g);
        bullet.paint(g);
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
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
            }
            /**
             * 判断方向
             */
            if (isL) {
                myTank.setDir(DirectionEnum.LFFT);
            }
            if (isR) {
                myTank.setDir(DirectionEnum.RIGHT);
            }
            if (isU) {
                myTank.setDir(DirectionEnum.UP);
            }
            if (isD) {
                myTank.setDir(DirectionEnum.DOWN);
            }

        }
    }

}
