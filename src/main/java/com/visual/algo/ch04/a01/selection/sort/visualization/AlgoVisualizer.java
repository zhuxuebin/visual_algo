package com.visual.algo.ch04.a01.selection.sort.visualization;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private SelectionSortData data;
    private static int DELAY = 20;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //初始化数据
        data = new SelectionSortData(N, screenHeight - 20);

        //初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("选择排序", screenWidth, screenHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run() {
        for (int i = 0; i < data.N() - 1; i++) {
            int minIndex = i;
            setData(i, -1, minIndex);
            for (int j = i + 1; j < data.N(); j++) {
                setData(i, j, minIndex);
                if (data.get(minIndex) > data.get(j)) {
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            if (minIndex != i) {
                data.swap(i, minIndex);
            }
            setData(i + 1, -1, -1);
        }
        setData(data.N(), -1, -1);
    }

    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex) {
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMinIndex = currentMinIndex;
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
        int screenWidth = 800;
        int screenHeight = 800;
        int N = 100;
        new AlgoVisualizer(screenWidth, screenHeight, N);
    }
}
