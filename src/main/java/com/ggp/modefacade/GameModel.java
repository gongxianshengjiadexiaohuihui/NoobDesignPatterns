package com.ggp.modefacade;

import com.ggp.base.GameObject;
import com.ggp.collidechainofresponsibility.BulletTankCollide;
import com.ggp.collidechainofresponsibility.CollideChain;
import com.ggp.collidechainofresponsibility.TankTankCollide;
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
 * @Description: 对外是 门面（客服） 对内是调停者（居委会大妈）
 */
public class GameModel {
    private BaseTank myTank = Config.gameFactory.createTank(200, 200,DirectionEnum.DOWN,GroupEnum.RED);
    private List<GameObject> objects = new ArrayList<>();
    private CollideChain chain  = new CollideChain();
    public GameModel() {
        int enemy =Config.enemyCount;
        for (int i = 0; i <enemy; i++) {
            this.add(Config.gameFactory.createTank(100*i,50*i,DirectionEnum.DOWN,GroupEnum.BLUE));
        }
    }


    public void paint(Graphics g){
        /**
         * 碰撞检测要放在绘制之前，不然，绘制时候已经碰撞上了，此时改完方向之后 依然是碰撞状态
         */
        this.collideCheck();
        myTank.paint(g);
        for (int i = 0; i <objects.size() ; i++) {
            objects.get(i).paint(g);
        }

    }

    /**
     * 碰撞检测
     */
    public void collideCheck(){
        for (int i = 0; i <objects.size() ; i++) {
            for (int j = i+1; j <objects.size() ; j++) {
                  chain.collide(objects.get(i),objects.get(j));
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
