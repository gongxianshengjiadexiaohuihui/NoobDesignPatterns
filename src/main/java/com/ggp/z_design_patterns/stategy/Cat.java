package com.ggp.z_design_patterns.stategy;

/**
 * @Author:GGP
 * @Date:2020/3/12 20:54
 * @Description:
 */
public class Cat implements Comparable<Cat> {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat o) {
        if(this.weight>o.weight){
            return 1;
        }else if(this.weight<o.weight){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }


}
