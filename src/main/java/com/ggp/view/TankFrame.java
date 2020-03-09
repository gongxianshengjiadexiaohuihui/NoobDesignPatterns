package com.ggp.view;

import com.ggp.common.ConstantCommand;
import com.ggp.common.DirectionEnum;

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
        g.fillRect(ConstantCommand.ENEMY_X, ConstantCommand.ENEMY_Y, 50, 50);
        enemy_move();
    }

    /**
     * 敌方坦克移动
     */
    private void enemy_move(){
        switch (ConstantCommand.ENEMY_DIR) {
            case LFFT:
                ConstantCommand.ENEMY_X -= ConstantCommand.SPEED;
                break;
            case RIGHT:
                ConstantCommand.ENEMY_X += ConstantCommand.SPEED;
                break;
            case UP:
                ConstantCommand.ENEMY_Y -= ConstantCommand.SPEED;
                break;
            case DOWN:
                ConstantCommand.ENEMY_Y += ConstantCommand.SPEED;
                break;
            default:
                break;
        }
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
            if (isL) {
                ConstantCommand.ENEMY_DIR = DirectionEnum.LFFT;
            }
            if (isR) {
                ConstantCommand.ENEMY_DIR = DirectionEnum.RIGHT;
            }
            if (isU) {
                ConstantCommand.ENEMY_DIR = DirectionEnum.UP;
            }
            if (isD) {
                ConstantCommand.ENEMY_DIR = DirectionEnum.DOWN;
            }
        }
    }

}
