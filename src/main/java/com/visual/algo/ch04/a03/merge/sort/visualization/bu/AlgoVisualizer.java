package com.visual.algo.ch04.a03.merge.sort.visualization.bu;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * 自顶向下
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private MergeSortData data;
    private static int DELAY = 20;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //初始化数据
        data = new MergeSortData(N, screenHeight);

        //初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("welcome", screenWidth, screenHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run() {
        setData(-1,-1,-1);
        sort(0, data.N() - 1);
        setData(0,data.N()-1,data.N()-1);
    }

    public void sort(int begin, int end) {
        if (begin >= end) {
            return;
        }
        setData(begin,end,-1);
        //divide
        int mid = begin + (end - begin) / 2;
        sort(begin, mid);
        sort(mid + 1, end);
        //merge
        merge(begin, mid, end);
    }

    //需要改造下
    public void merge(int begin, int mid, int end) {
        //begin-mid,mid+1-end
        int i = 0, j = mid + 1-begin, index = begin;
        int[] aux = Arrays.copyOfRange(data.numbers, begin, end+1);
        while (i <= mid-begin && j <= end-begin) {
            if (aux[i] <= aux[j]) {
                data.numbers[index++] = aux[i++];
            } else {
                data.numbers[index++] = aux[j++];
            }
            setData(begin,end,index-1);
        }
        while (i <= mid-begin) {
            data.numbers[index++] = aux[i++];
            setData(begin,end,index-1);
        }
        while (j <= end-begin) {
            data.numbers[index++] = aux[j++];
            setData(begin,end,index-1);
        }
    }

    private void setData(int l, int r, int mergeIndex) {
        data.l = l;
        data.r = r;
        data.mergeIndex = mergeIndex;
        algoFrame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        new AlgoVisualizer(800,600,100);
    }
}
