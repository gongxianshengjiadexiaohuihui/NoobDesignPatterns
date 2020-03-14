package com.ggp.common;

import com.ggp.factory.GameFactory;
import com.ggp.factory.SunGameFactory;
import com.ggp.firestategy.DefaultFireStrategy;
import com.ggp.firestategy.FireStrategy;
import com.ggp.firestategy.FourFireStrategy;

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
    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return (String) properties.get(key);
    }

    /**
     * 获取主站坦克开火策略
     * @return
     */
    public static FireStrategy getFireStrategy(){
        int i = Integer.valueOf(get("fireStrategy"));
        if(i == 2){
            return new FourFireStrategy();
        }
        return new DefaultFireStrategy();
    }
}
