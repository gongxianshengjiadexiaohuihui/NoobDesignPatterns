package com.ggp.modefacade;

import com.ggp.base.GameObject;
import com.ggp.collidechainofresponsibility.BulletTankCollide;
import com.ggp.collidechainofresponsibility.Collide;
import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.base.BaseTank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/15 21:41
 * @Description: 数据模型
 */
public class GameModel {
    private BaseTank myTank = Config.gameFactory.createTank(200, 200,DirectionEnum.DOWN,GroupEnum.RED);
    private List<GameObject> objects = new ArrayList<>();
    private Collide bulletTankCollide = new BulletTankCollide();
    public GameModel() {
        int enemy =Config.enemyCount;
        for (int i = 0; i <enemy; i++) {
            this.add(Config.gameFactory.createTank(50*i,100,DirectionEnum.DOWN,GroupEnum.BLUE));
        }
    }


    public void paint(Graphics g){
        myTank.paint(g);
        for (int i = 0; i <objects.size() ; i++) {
            objects.get(i).paint(g);
        }
        this.collideCheck();
    }

    /**
     * 碰撞检测
     */
    public void collideCheck(){
        for (int i = 0; i <objects.size() ; i++) {
            for (int j = i+1; j <objects.size() ; j++) {
                bulletTankCollide.collide(objects.get(i),objects.get(j));
            }
        }
    }
    public BaseTank getMainTank(){
        return myTank;
    }

    /**
     * 添加游戏物体
     * @param object
     */
    public void add(GameObject object){
        objects.add(object);
    }

    /**
     * 移除游戏物体
     * @param object
     */
    public void remove(GameObject object){
        objects.remove(object);
    }
}
