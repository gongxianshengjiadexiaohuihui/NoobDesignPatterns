package com.ggp;


import com.ggp.view.TankFrame;

/**
 * @Author:GGP
 * @Date:2020/3/9 19:08
 * @Description:
 */
public class StartUp {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while (true){
            Thread.sleep(100);
            tankFrame.repaint();
        }
    }
}
