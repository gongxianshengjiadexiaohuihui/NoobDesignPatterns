package com.ggp.z_design_patterns.stategy;

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
        /**
         * lambda表达式
         */
//        a = sorter.sort(cats,(t1,t2)->{
//            if(t1.height>t2.height){
//                return 1;
//            }else if(t1.height<t2.height){
//                return -1;
//            }else {
//                return 0;
//            }
//        });
        System.out.println(Arrays.toString(a));
    }
}
