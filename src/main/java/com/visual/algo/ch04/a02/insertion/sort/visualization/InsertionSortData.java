package com.visual.algo.ch04.a02.insertion.sort.visualization;

import java.util.Arrays;

public class InsertionSortData {

    public enum Type{
        Default,
        NearlyOrdered
    }

    private int[] numbers;

    public int orderedIndex = -1;           // [0...orderedIndex) 是有序的
    public int currentCompareIndex = -1;    // 当前正在比较的元素索引

    public InsertionSortData(int N, int randomBound, Type dataType){

        numbers = new int[N];

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;

        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.02*N);
            int a = (int)(Math.random()*N);
            int b = (int)(Math.random()*N);
            swap(a, b);
        }
    }

    public int N(){
        return numbers.length;
    }

    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        return numbers[index];
    }

    public void set(int destIndex, int value) {
        numbers[destIndex] = value;
    }

    public void swap(int i, int j) {
        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
