package com.ggp;


import com.ggp.common.*;
import com.ggp.organ.Tank;
import com.ggp.view.TankFrame;

/**
 * @Author:GGP
 * @Date:2020/3/9 19:08
 * @Description:
 */
public class StartUp {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int enemy = Integer.valueOf((String) PropertiesManager.get("initEnemyCount"));
        for (int i = 0; i <enemy; i++) {
            tankFrame.getEnemyTanks().add(new Tank(50*i,100,DirectionEnum.DOWN,tankFrame,Group.BLUE));
        }
        new Thread(()-> new Audio("audio/war1.wav").loop()).start();
        while (true){
            Thread.sleep(100);
            tankFrame.repaint();
        }
    }
}
