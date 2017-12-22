package com.visual.algo.ch03.a02.monte.carlo.simulation;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private static int DELAY = 40;
    private AlgoFrame algoFrame;
    private Circle circle;
    private int N;
    private MonteCarloPiData piData;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {
        if (screenWidth != screenHeight)
            throw new IllegalArgumentException("This demo must be run in a square window!");

        // 初始化数据
        circle = new Circle(screenWidth / 2, screenHeight / 2, screenWidth / 2);
        this.N = N;
        piData = new MonteCarloPiData(circle);


        // 初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("get pi with monte carlo", screenWidth, screenHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run() {
        //编写自己的动画逻辑
        for (int i = 0; i < N; i++) {
            if (i % 100 == 0) {
                algoFrame.render(piData);
                AlgoVisHelper.pause(DELAY);
                System.out.println(piData.estimatePi());
            }
            int x = (int) (Math.random() * algoFrame.getCanvasWidth());
            int y = (int) (Math.random() * algoFrame.getCanvasHeight());
            Point p = new Point(x, y);
            piData.addPoint(p);
        }
    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        new AlgoVisualizer(800, 800, 20000);
    }
}
