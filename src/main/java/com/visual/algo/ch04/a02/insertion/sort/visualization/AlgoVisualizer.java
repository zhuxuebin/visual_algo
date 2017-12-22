package com.visual.algo.ch04.a02.insertion.sort.visualization;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private InsertionSortData data;
    private static int DELAY = 40;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //初始化数据
        data = new InsertionSortData(N, screenHeight - 20, InsertionSortData.Type.NearlyOrdered);

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
        for (int i = 1; i < data.N(); i++) {
            setData(i,i);//###
            if(data.get(i-1) > data.get(i)){
                int curr = data.get(i);
                int j = i-1;
                while(j >= 0 && data.get(j) > curr){
                    data.set(j+1,data.get(j));
                    setData(i,j);//###
                    j--;
                }
                setData(i+1,-1);
                data.set(j+1,curr);
            }
        }
    }

    private void setData(int orderedIndex, int currentCompareIndex) {
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
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
