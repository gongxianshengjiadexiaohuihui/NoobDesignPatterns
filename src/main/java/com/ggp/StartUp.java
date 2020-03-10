package com.ggp;


import com.ggp.common.Constant;
import com.ggp.common.DirectionEnum;
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
        for (int i = 0; i <Constant.ENEMY_COUNT; i++) {
            tankFrame.getEnemyTanks().add(new Tank(50*i,100,DirectionEnum.DOWN,tankFrame));
        }
        while (true){
            Thread.sleep(100);
            tankFrame.repaint();
        }
    }
}
