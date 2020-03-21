package com.ggp.common;

import java.io.File;

/**
 * @Author:GGP
 * @Date:2020/3/9 19:51
 * @Description:
 */
public class Constant {
    /**
     * 游戏界面长度
     */
    public static  final Integer GAME_WIDTH = 1060;
    /**
     * 游戏界面宽度
     */
    public static  final Integer GAME_HEIGHT = 960;
    /**
     * 坦克速度
     */
    public static final Integer TANK_SPEED = 5;
    /**
     * 子弹速度
     */
    public static final Integer BULLET_SPEED =10;
    /**
     * 敌方tank数量
     */
    public static final Integer ENEMY_COUNT=5;




    /**
     * 备份文件路径
     */
    public static final String BACK_UP_PATH=System.getProperty("user.dir")+File.separator+"back_up_data";
}

