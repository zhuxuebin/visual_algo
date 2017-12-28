package com.visual.algo.ch04.a03.merge.sort.visualization.td;

/**
 * Created by xuery on 2017/12/24.
 */
public class MyMergeSort {

    private MyMergeSort(){}

    public static void main(String[] args) {
        int[] arr = new int[]{20,10,11,9,3,15};
        MyMergeSort.mergeSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] arrCopy = new int[arr.length];
        sort(arr, arrCopy,0, arr.length - 1);
    }

    public static void sort(int[] arr, int[] arrCopy, int begin, int end) {
        if (begin >= end) {
            return;
        }
        //divide
        int mid = begin + (end - begin) / 2;
        sort(arr, arrCopy,begin, mid);
        sort(arr, arrCopy,mid + 1, end);
        //merge
        merge(arr, arrCopy,begin, mid, end);
    }

    public static void merge(int[] arr, int[] arrCopy, int begin, int mid, int end) {
        //begin-mid,mid+1-end
        int i = begin, j = mid + 1, index = i;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                arrCopy[index++] = arr[i++];
            } else {
                arrCopy[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            arrCopy[index++] = arr[i++];
        }
        while (j <= end) {
            arrCopy[index++] = arr[j++];
        }
        for(int k=begin;k<=end;k++){
            arr[k] = arrCopy[k];
        }
    }
}
