package com.visual.algo.ch04.a02.insertion.sort.visualization;

import java.util.Arrays;

/**
 * Created by xuery on 2017/12/22.
 */
public class MyInsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{50, 20, 70, 30, 40, 60, 35};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] > arr[i]){
                int curr = arr[i];
                int j = i-1;
                while(j >= 0 && arr[j] > curr){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = curr;
            }
        }
    }
}
