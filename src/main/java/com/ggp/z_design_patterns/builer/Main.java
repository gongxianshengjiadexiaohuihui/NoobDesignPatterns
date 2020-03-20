package com.ggp.z_design_patterns.builer;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:49
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuiler().buileName("ggp").buildAge(18).builder();
        System.out.println(person);
    }
}
