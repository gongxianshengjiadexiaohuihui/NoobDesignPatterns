package com.ggp.modefacade;

import com.ggp.common.Config;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.organ.BaseBullet;
import com.ggp.organ.BaseExplode;
import com.ggp.organ.BaseTank;

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
    /**
     * 所有子弹
     */
    public List<BaseBullet> bullets = new ArrayList<>();
    /**
     * 敌方坦克
     */
    public List<BaseTank> enemyTanks = new ArrayList<>();
    /**
     * 所有爆炸
     */
    public List<BaseExplode> explodes = new ArrayList<>();

    public GameModel() {
        int enemy = Integer.valueOf((String) Config.get("initEnemyCount"));
        for (int i = 0; i <enemy; i++) {
            this.enemyTanks.add(Config.gameFactory.createTank(50*i,100,DirectionEnum.DOWN,GroupEnum.BLUE));
        }
    }

    public void paint(Graphics g){
        myTank.paint(g);
        /**
         * 画子弹
         */
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        /**
         * 画敌方坦克
         */
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).paint(g);
        }
        /**
         * 画爆炸
         */
        for (int i = 0; i <explodes.size() ; i++) {
            explodes.get(i).paint(g);
        }
        /**
         * 检测子弹撞击
         */
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemyTanks.size(); j++) {
                bullets.get(i).collideWith(enemyTanks.get(j));
            }
        }
    }
    public BaseTank getMainTank(){
        return myTank;
    }
}
