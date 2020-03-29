package com.ggp.start;


import com.ggp.common.Config;
import com.ggp.net.Client;
import com.ggp.net.message.TankJoinMessage;
import com.ggp.source.AudioManager;
import com.ggp.view.GameFrame;

/**
 * @Author:GGP
 * @Date:2020/3/9 19:08
 * @Description:
 */
public class StartUp {
    public static void main(String[] args) throws InterruptedException {
        GameFrame frame = new GameFrame();

        new Thread(() -> new AudioManager("audio/war1.wav").loop()).start();
        new Thread(() -> Client.INSTANCE.connect()).start();
        Thread.sleep(1000);
        Config.gameModel.getMainTank().name = "ggp1";
        Client.INSTANCE.sendMsg(new TankJoinMessage(Config.gameModel.getMainTank()));

        while (true) {
            Thread.sleep(100);
            frame.repaint();
        }
    }
}
