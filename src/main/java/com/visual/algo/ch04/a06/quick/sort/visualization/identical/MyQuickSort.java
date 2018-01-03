package com.visual.algo.ch04.a06.quick.sort.visualization.identical;


import com.visual.algo.utils.ArrayUtils;

/**
 * Created by xuery on 2017/12/28.
 */
public class MyQuickSort {


    public static int partition(int[] arr, int left, int right) {
        int originLeft = left;
        int v = arr[left];
        while (left < right) {
            while (arr[right] >= v && left < right) {
                right--;
            }
            while (arr[left] <= v && left < right) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, originLeft);
        return left;
    }

    public static int partition2(int[] arr, int left, int right) {
        int v = arr[left];
        while (left < right) {
            if (arr[left] == v) {
                while (arr[right] >= v && left < right) {
                    right--;
                }
                swap(arr, left, right);
                left++;
            } else {
                while (arr[left] <= v && left < right) {
                    left++;
                }
                swap(arr, left, right);
                right--;
            }
        }
        return left;
    }

    public static int partition3(int[] arr, int left, int right) {

        int v = arr[left];
        int j = left; //arr[left+1...j] arr[j+1...right]
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] < v){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,left,j);
        return j;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int p = partition3(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 15, 30, 20, 12};
//        int[] arr = new int[]{20, 12, 20, 30, 15};
        quickSort(arr, 0, arr.length - 1);
        ArrayUtils.printArr(arr);
    }
}
