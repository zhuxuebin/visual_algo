package com.visual.algo.ch03.a01.money.experiment;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private static int DELAY = 10;
    private AlgoFrame algoFrame;
    private int[] data;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //初始化数据
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = 100;
        }

        //初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("welcome", screenWidth, screenHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    //N个人，初始钱数相同，然后每一轮每个人随机给另外一个人一块钱
    private void run() {
        //编写自己的动画逻辑
        int count = 0;
        while (count++ < 32768) {
            Arrays.sort(data);
            algoFrame.render(data);
            AlgoVisHelper.pause(DELAY);
            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < data.length; i++) {
//                    if (data[i] > 0) {
                        int j = (int) (Math.random() * data.length);
                        data[i] -= 1;
                        data[j] += 1;
//                    }
                }
            }
        }
    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        new AlgoVisualizer(800, 800, 100);
    }
}
