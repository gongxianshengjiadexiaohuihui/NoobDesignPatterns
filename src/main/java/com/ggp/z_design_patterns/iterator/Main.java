package com.ggp.z_design_patterns.iterator;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:32
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>  arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        LinkList<String> linkList = new LinkList<>();
        linkList.add("1");
        linkList.add("2");
        linkList.add("3");
        linkList.add("4");
        linkList.add("5");
        iterator  =  linkList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
