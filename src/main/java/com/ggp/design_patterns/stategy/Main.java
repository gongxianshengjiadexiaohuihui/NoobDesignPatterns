package com.ggp.design_patterns.stategy;

import java.util.Arrays;

/**
 * @Author:GGP
 * @Date:2020/3/12 20:44
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{4,5,2,5,2};
        System.out.println(Arrays.toString(Sorter.sort(a)));
    }
}
