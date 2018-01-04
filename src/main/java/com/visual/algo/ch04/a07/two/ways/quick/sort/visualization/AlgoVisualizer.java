package com.visual.algo.ch04.a07.two.ways.quick.sort.visualization;

import com.visual.algo.utils.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * 一般用的快排都是双路快排
 * Created by 01368080 on 2017/12/20.
 */
public class AlgoVisualizer {

    private AlgoFrame algoFrame;
    private TwoWaysQuickSortData data;
    private static int DELAY = 40;

    public AlgoVisualizer(int screenWidth, int screenHeight, int N, TwoWaysQuickSortData.Type dataType) {

        //初始化数据
        data = new TwoWaysQuickSortData(N, screenHeight, dataType);


        //初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("welcome", screenWidth, screenHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        this(sceneWidth, sceneHeight, N, TwoWaysQuickSortData.Type.Default);
    }

    //动画逻辑
    private void run() {
        setData(-1, -1, -1, -1,-1, -1);
        twoWaysQuickSort(0,data.N()-1);
        setData(-1, -1, -1, -1,-1, -1);
    }

    public void twoWaysQuickSort(int left, int right) {

        if (left > right) {
            return;
        }
        if(left == right){
            setData(left, right, left, -1, -1,-1);
            return;
        }
        setData(left, right, -1,-1, -1, -1);
        int p = partition(left, right);
        twoWaysQuickSort(left, p - 1);
        twoWaysQuickSort(p + 1, right);
    }

    /**
     * 参考网上的双路快排
     * @param left
     * @param right
     * @return
     */
    public int partition(int left, int right){

        setData(left, right, -1, left, -1, -1);
        int v = data.get(left);
        int lb = left, rb = right;
        while(lb < rb){
            //注意这里必须先从右边开始，举个例子就明白了 20 15 20 30
            while(lb < rb && data.get(rb) >= v){
                rb--;
                setData(left, right, -1, left, lb, rb);
            }
            while(lb < rb && data.get(lb) <= v){
                lb++;
                setData(left, right, -1, left, lb, rb);
            }
            data.swap(lb,rb);
            setData(left, right, -1, left, lb, rb);
        }
        data.swap(left,rb);
        setData(left, right, rb, -1, -1, -1);
        return rb;
    }

    /**
     * bobo的双路快排
     * @param left
     * @param right
     * @return
     */
    public int partition4(int left, int right){
        int p = (int)(Math.random()*(right-left+1))+left;
        setData(left, right, -1, p, -1,-1);

        data.swap(left,p);
        int v = data.numbers[left];
        setData(left, right, -1, left, -1, -1);

        int lb = left + 1, rb = right;
        while(true){
            while(lb <= right && data.get(lb) < v){
                lb++;
                setData(left, right, -1, left, lb, rb);
            }
            while(rb >= left+1 && data.get(rb) > v){
                rb--;
                setData(left, right, -1, left, lb, rb);
            }
            if(lb > rb){
                break;
            }
            data.swap(lb,rb);
            lb++;
            rb--;
            setData(left, right, -1, left, lb, rb);
        }
        data.swap(left,rb);
        setData(left, right, rb, -1, -1, -1);
        return rb;
    }

    //添加一个键盘事件
    private class AlgoKeyListener extends KeyAdapter {

    }

    //添加一个鼠标事件
    private class AlgoMouseListener extends MouseAdapter {

    }
    private void setData(int l, int r, int fixedPivot, int curPivot, int curL, int curR){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;

        algoFrame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new AlgoVisualizer(800,800,100, TwoWaysQuickSortData.Type.Default);
    }
}
