package com.ggp.z_design_patterns.prototype;

/**
 * @Author:GGP
 * @Date:2020/3/21 22:56
 * @Description: 原型模式 又叫克隆模式，java的类 必须实现Cloneable接口，这个接口只是标记作用
 * java的 克隆只是 把内存中的这一块复制出来，所以该对象如果成员是引用，那么复制的也是引用。
 * 所以分为浅克隆和深克隆
 * 浅克隆就是复制的引用。。这样复制后的对象在使用过程中就会相互影响
 * 深克隆就是把引用指向的对象也复制一份。
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Location location = new Location(1, 2);
        Person person = new Person("ggp", location);
        Person person1 = (Person) person.clone();
        System.out.println(person == person1);
        System.out.println(person.location == person1.location);
        person1.location.setX(2);
        System.out.println(person.location.getX());

    }
}
