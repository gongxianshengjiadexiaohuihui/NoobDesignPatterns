package com.ggp.net;

import com.ggp.common.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author:GGP
 * @Date:2020/3/28 15:34
 * @Description:
 */
public class ServerFrame extends Frame {
    public static ServerFrame INSTANCE = new ServerFrame();
    private TextArea textArea;
    private ServerFrame(){
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setTitle("服务端消息");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        textArea = new TextArea();
        textArea.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.add(textArea);
        this.setVisible(true);

    }
    public void append(String msg){
        textArea.append(msg);
        textArea.append(System.getProperty("line.separator"));
    }
}
