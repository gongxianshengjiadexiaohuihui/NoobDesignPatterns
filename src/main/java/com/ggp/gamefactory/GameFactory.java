package com.ggp.gamefactory;

import com.ggp.common.enums.DirectionEnum;
import com.ggp.common.enums.GroupEnum;
import com.ggp.base.BaseBullet;
import com.ggp.base.BaseExplode;
import com.ggp.base.BaseTank;

/**
 * @Author:GGP
 * @Date:2020/3/14 15:10
 * @Description:
 */
public abstract class GameFactory {
    /**
     * 坦克图片宽度
     */
    public int tankWeight;
    /**
     * 坦克图片高度
     */
    public int tankHeight;
    /**
     * 字段图片宽度
     */
    public int bulletWeight;
    /**
     * 子弹图片高度
     */
    public int bulletHeight;
    /**
     * 爆炸图片宽度
     */
    public int explodeWeight;
    /**
     * 爆炸图片高度
     */
    public int explodeHeight;

    /**
     * 创建坦克
     * @param x 横坐标
     * @param y 纵坐标
     * @param dir 方向
     * @param groupEnum  分组
     * @return
     */
    public abstract BaseTank createTank(int x, int y, DirectionEnum dir, GroupEnum groupEnum);

    /**
     * 创建爆炸
     * @param x  横坐标
     * @param y  纵坐标
     * @return
     */
    public abstract BaseExplode createExplode(int x, int y);

    /**
     * 创建子弹
     * @param x  横坐标
     * @param y  纵坐标
     * @param dir  方向
     * @param groupEnum  分组
     * @return
     */
    public abstract BaseBullet createBullet(int x, int y, DirectionEnum dir, GroupEnum groupEnum);
}
