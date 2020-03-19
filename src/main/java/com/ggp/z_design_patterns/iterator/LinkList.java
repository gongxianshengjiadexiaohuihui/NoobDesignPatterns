package com.ggp.z_design_patterns.iterator;

/**
 * @Author:GGP
 * @Date:2020/3/19 21:24
 * @Description:
 */
public class LinkList<E> implements Collection<E> {
    Node head= null;
    Node tail = null;

    @Override
    public void add(E e) {
        Node node = new Node(e);
        node.next = null;
        if(null == head){
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = node;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node index = head;
            @Override
            public boolean hasNext() {
                if(null == index){
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                E e = (E)index.o;
                index = index.next;
                return e;
            }
        };
    }
}
class  Node{
    Object o;
    Node next;

    public Node(Object o) {
        this.o = o;
    }
}
