package com.visual.algo.utils;

/**
 * Created by xuery on 2018/1/1.
 */
public class ArrayUtils {

    private ArrayUtils(){}

    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
