package com.ggp.common;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author:GGP
 * @Date:2020/3/11 21:21
 * @Description:
 */
public class PropertiesManager {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        return properties.get(key);
    }
}
