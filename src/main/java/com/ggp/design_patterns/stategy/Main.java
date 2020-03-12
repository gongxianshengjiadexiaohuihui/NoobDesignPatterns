package com.ggp.design_patterns.stategy;

import java.util.Arrays;

/**
 * @Author:GGP
 * @Date:2020/3/12 20:44
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats={new Cat(5,1),new Cat(4,2),new Cat(3,3)};
        Sorter<Cat> sorter = new Sorter<>();
        Cat[] a = sorter.sort(cats,new CompareWeightComparator());
        System.out.println(Arrays.toString(a));
        a = sorter.sort(cats,new CompareHeightComparator());
        System.out.println(Arrays.toString(a));
    }
}
