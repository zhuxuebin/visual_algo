package com.visual.algo.ch04.a03.merge.sort.visualization.td;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
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

    //todo 动画逻辑
    private void run() {
        setData(-1,-1,-1);
        int[] arrCopy = new int[data.N()];
        sort(arrCopy, 0, data.N() - 1);
        setData(0,data.N()-1,data.N()-1);
    }

    public void sort(int[] arrCopy, int begin, int end) {
        if (begin >= end) {
            return;
        }
        setData(begin,end,-1);
        //divide
        int mid = begin + (end - begin) / 2;
        sort(arrCopy, 0, mid);
        sort(arrCopy, mid + 1, end);
        //merge
        merge(arrCopy, 0, mid, end);
    }

    public void merge(int[] arrCopy, int begin, int mid, int end) {
        //begin-mid,mid+1-end
        int i = begin, j = mid + 1, index = i;
        int[] aux = Arrays.copyOfRange(data.numbers, begin, end+1);
        while (i <= mid && j <= end) {
            if (data.get(i) <= data.get(j)) {
                data.set(index++,aux[i++]);
            } else {
                arrCopy[index++] = aux[j++];
            }
            setData(begin,end,index-1);
        }
        while (i <= mid) {
            arrCopy[index++] = aux[i++];
        }
        while (j <= end) {
            arrCopy[index++] = aux[j++];
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
        new AlgoVisualizer(800,600,10);
    }
}
