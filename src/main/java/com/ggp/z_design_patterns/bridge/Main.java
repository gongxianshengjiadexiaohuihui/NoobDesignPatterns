package com.ggp.z_design_patterns.bridge;

/**
 * @Author:GGP
 * @Date:2020/3/21 17:30
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        /**
         *  分离抽象和具体实现，让抽象和实现在两个维度自由发展，防止类爆炸
         *  然后通过桥接 联系抽象类和具体实现类
         *
         */
        Gift gift = new WarmGift(new BookGift());
        Gift gift1 = new WildGift(new FlowerGift());
    }
}
