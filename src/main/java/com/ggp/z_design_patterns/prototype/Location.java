package com.ggp.z_design_patterns.prototype;

/**
 * @Author:GGP
 * @Date:2020/3/21 22:52
 * @Description:
 */
public class Location implements Cloneable{
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
