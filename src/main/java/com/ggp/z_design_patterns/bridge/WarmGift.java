package com.ggp.z_design_patterns.bridge;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:27
 * @Description:
 */
public class WarmGift extends Gift {
    public WarmGift(GiftImpl gift) {
        this.impl = gift;
    }
}
