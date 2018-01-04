package com.visual.algo.ch04.a07.two.ways.quick.sort.visualization;

import java.util.Arrays;

public class TwoWaysQuickSortData {

    public enum Type{
        Default,
        NearlyOrdered,
        Identical
    }

    public int[] numbers;
    public int l, r;              //最左最右边界
    public boolean[] fixedPivots; //left == right时为true
    public int curPivot;          //当前partition参考点下标
    public int curL, curR;        //双路快排partition过程中的左右lb/rb

    public TwoWaysQuickSortData(int N, int randomBound, Type dataType){

        numbers = new int[N];
        fixedPivots = new boolean[N];

        int lBound = 1;
        int rBound = randomBound;

        if(dataType == Type.Identical){
            int mid = (lBound+rBound)/2;
            lBound = mid;
            rBound = mid;
        }

        for( int i = 0 ; i < N ; i ++) {
            numbers[i] = (int)(Math.random()*(rBound-lBound+1)) + lBound;
            fixedPivots[i] = false;
        }

        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int)(0.01*N);
            for(int i = 0 ; i < swapTime; i ++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a, b);
            }
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

    public void swap(int i, int j) {

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}