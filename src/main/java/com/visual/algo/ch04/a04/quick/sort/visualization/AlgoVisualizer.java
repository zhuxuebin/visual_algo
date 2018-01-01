package com.visual.algo.ch04.a04.quick.sort.visualization;

import com.visual.algo.utils.AlgoVisHelper;
import com.visual.algo.utils.ArrayUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private QuickSortData data;
    private static int DELAY = 40;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //初始化数据
        data = new QuickSortData(N, screenHeight);


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
        setData(-1, -1, -1, -1, -1);
        quickSort(0,data.N()-1);
        setData(-1, -1, -1, -1, -1);
    }

    public int partition3(int left, int right) {

        int v = data.numbers[left];
        int j = left; //arr[left+1...j] arr[j+1...right]
        for (int i = left + 1; i <= right; i++) {
            if(data.numbers[i] < v){
                j++;
                data.swap(i,j);
                setData(left, right, -1, left, i);
            }
        }
        data.swap(left,j);
        setData(left, right, j, -1, -1);
        return j;
    }

    public void quickSort(int left, int right) {

        if (left >= right) {
            return;
        }
        setData(left, right, -1, -1, -1);
        int p = partition3(left, right);
        quickSort(left, p - 1);
        quickSort(p + 1, right);
    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }
    private void setData(int l, int r, int fixedPivot, int curPivot, int curElement){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curElement = curElement;

        algoFrame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new AlgoVisualizer(800,800,100);
    }
}
