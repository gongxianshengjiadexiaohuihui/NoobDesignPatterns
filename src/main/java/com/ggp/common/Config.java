package com.ggp.common;

import com.ggp.gamefactory.GameFactory;
import com.ggp.gamefactory.SunGameFactory;
import com.ggp.firestrategy.DefaultFireStrategy;
import com.ggp.firestrategy.FireStrategy;
import com.ggp.firestrategy.FourFireStrategy;
import com.ggp.modefacade.GameModel;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author:GGP
 * @Date:2020/3/11 21:21
 * @Description:
 */
public class Config {
    public static Properties properties = new Properties();

    /**
     * 默认的游戏工厂
     */
    //public  static GameFactory gameFactory = new DefaultGameFactory();
    public static  GameFactory gameFactory = new SunGameFactory();

    /**
     * 游戏模型 --- 门面
     */
    public static GameModel gameModel;

    public static int enemyCount;
    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
            enemyCount = getInt("initEnemyCount");
            /**
             * gameModel初始化用到config了，所以在解析完配置爱文件后初始化它
             */
            gameModel = GameModel.getInstance();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key){
        return (String) properties.get(key);
    }
    public static int getInt(String key){
        return Integer.valueOf(getString(key));
    }
    /**
     * 获取主站坦克开火策略
     * @return
     */
    public static FireStrategy getFireStrategy(){
        int i = Integer.valueOf(getString("fireStrategy"));
        if(i == 2){
            return new FourFireStrategy();
        }
        return new DefaultFireStrategy();
    }

}
