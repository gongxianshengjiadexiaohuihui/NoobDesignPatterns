package com.ggp.z_design_patterns.prototype;

/**
 * @Author:GGP
 * @Date:2020/3/21 22:51
 * @Description:
 */
public class Person implements Cloneable{
    private String name;
    public Location location;

    public Person(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public Object  clone() throws CloneNotSupportedException{
//        Person person = (Person) super.clone();
//        person.location = (Location) location.clone();
//        return person;
        return super.clone();
    }
}
