package com.visual.algo.ch04.a01.selection.sort.visualization;

import java.util.Arrays;

/**
 * Created by xuery on 2017/12/21.
 * 冒泡排序
 */
public class MyPopSort {

    public static void main(String[] args) {
        int[] arr = new int[]{50, 15, 20, 91, 70, 23};
//        popSort(arr);
        selectSort(arr);
        for (int val : arr) {
            System.out.println(val);
        }
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                sort(arr, i, minIndex);
            }
        }

    }

    public static void popSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort(arr, j, j+1);
                }
            }
        }
    }

    private static void sort(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
