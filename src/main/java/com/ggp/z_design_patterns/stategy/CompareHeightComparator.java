package com.ggp.z_design_patterns.stategy;

/**
 * @Author:GGP
 * @Date:2020/3/12 21:25
 * @Description:
 */
public class CompareHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if(t1.height>t2.height){
            return 1;
        }else if(t1.height<t2.height){
            return -1;
        }else {
            return 0;
        }
    }
}
