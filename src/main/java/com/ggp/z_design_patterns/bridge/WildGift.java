package com.ggp.z_design_patterns.bridge;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:28
 * @Description:
 */
public class WildGift extends Gift {
    public WildGift(GiftImpl gift) {
        this.impl = gift;
    }
}
