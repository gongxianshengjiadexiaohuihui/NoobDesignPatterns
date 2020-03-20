package com.ggp.z_design_patterns.builer;

/**
 * @Author:GGP
 * @Date:2020/3/20 23:40
 * @Description:
 */
public class Person {
    private int age;
    private String  name;
    private String sex;
    private int height;
    private int weight;
    private Person(){}
    public static class PersonBuiler{
        private Person person = new Person();
        public  PersonBuiler buildAge(int age){
            person.age = age;
            return this;
        }
        public PersonBuiler buileName(String name){
            person.name = name;
            return this;
        }
        public PersonBuiler buileSex(String sex){
            person.sex = sex;
            return this;
        }
        public PersonBuiler buileHeight(int height){
            person.height = height;
            return this;
        }
        public PersonBuiler buileWeight(int weight){
            person.weight = weight;
            return this;
        }
        public Person builder(){
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
