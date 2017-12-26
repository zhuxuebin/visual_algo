package com.visual.algo.template;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private Object data;
    private static int DELAY;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N) {

        //todo 初始化数据


        //todo 初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("welcome", screenWidth, screenHeight);
            //todo 根据具体情况加入监听事件
            algoFrame.addKeyListener(new AlgoKeyListener());
            algoFrame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    //todo 动画逻辑
    private void run() {

    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {

    }
}
