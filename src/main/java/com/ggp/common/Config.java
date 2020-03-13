package com.ggp.common;

import com.ggp.fire.DefaultFireStrategy;
import com.ggp.fire.FireStrategy;
import com.ggp.fire.FourFireStrategy;

import java.io.IOException;
import java.util.Properties;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * @Author:GGP
 * @Date:2020/3/11 21:21
 * @Description:
 */
public class Config {
    static Properties properties = new Properties();

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
    public static FireStrategy getFireStategy(){
        int i = Integer.valueOf(get("fireStrategy"));
        if(i == 2){
            return new FourFireStrategy();
        }
        return new DefaultFireStrategy();
    }
}
