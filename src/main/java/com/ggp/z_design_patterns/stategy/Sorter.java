package com.ggp.z_design_patterns.stategy;


/**
 * @Author:GGP
 * @Date:2020/3/12 20:43
 * @Description:
 */
public class Sorter<T> {
    public T[] sort(T[] arr,Comparator<T> comparator){
        for (int i = 0; i <arr.length ; i++) {
            int minPos = i;
            for (int j = i; j <arr.length ; j++) {
                minPos = comparator.compare(arr[i],arr[j]) == -1?i:j;
            }
            swap(arr,i,minPos);
        }
        return  arr;
    }

    private void swap(T[] arr, int i, int minPos) {
        T temp = arr[i];
        arr[i] =  arr[minPos];
        arr[minPos] = temp;
    }

}
