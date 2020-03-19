package com.ggp.z_design_patterns.iterator;

/**
 * @Author:GGP
 * @Date:2020/3/19 19:51
 * @Description:
 */
public class ArrayList<E> implements Collection<E> {
    private E[] elements = (E[])new Object[5];
    private int index = 0;
    @Override
    public void add(E e) {
        if(index == elements.length){
            E[] temp = (E[])new Object[elements.length*2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;
        }
        elements[index++] = e;
    }

    /**
     * 内部类的优点
     * 1、拥有对一些私有属性的访问权限
     * 2、这个类没有用到，不必暴露
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                if(currentIndex == elements.length){
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                return elements[currentIndex++];
            }
        };
    }
}
