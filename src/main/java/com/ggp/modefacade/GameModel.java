package com.ggp.modefacade;

import com.ggp.base.BaseTank;
import com.ggp.base.GameObject;
import com.ggp.collidechainofresponsibility.CollideChain;
import com.ggp.common.Config;
import com.ggp.common.Constant;
import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.organ.Wall;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GGP
 * @Date:2020/3/15 21:41
 * @Description: 对外是 门面（客服） 对内是调停者（居委会大妈）
 */
public class GameModel implements Serializable {
    private BaseTank myTank = Config.gameFactory.createTank(200, 200,DirectionEnum.DOWN,GroupEnum.RED);
    private List<GameObject> objects = new ArrayList<>();
    private CollideChain chain  = new CollideChain();

    /**
     * 单例--懒加载
     */
    private static class Internal {
        public static final GameModel INSTANCE = new GameModel();
    }
    public static GameModel getInstance(){
        return Internal.INSTANCE;
    }
    private GameModel() {
        int enemy =Config.enemyCount;
        for (int i = 0; i <enemy; i++) {
            this.add(Config.gameFactory.createTank(100*i,50*i,DirectionEnum.DOWN,GroupEnum.BLUE));
        }
            this.add(new Wall(450, 400));
            this.add(new Wall(510,400));
            this.add(new Wall(570,400));
            this.add(new Wall(630,400));
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

    /**
     * 记录快照
     */
    public void save(){
        File file = new File(Constant.BACK_UP_PATH);
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 恢复快照
     */
    public void recover(){
        File file = new File(Constant.BACK_UP_PATH);
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Config.gameModel = (GameModel)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
