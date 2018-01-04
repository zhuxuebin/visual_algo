package com.visual.algo.ch04.a07.two.ways.quick.sort.visualization;

import com.visual.algo.utils.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        setContentPane(new AlgoCanvas()); //JFrame相当于画板，JPanel相当于画布（中间介质）
        pack(); //根据子组件preferredSize等属性自动调节窗口大小

//        setSize(canvasWidth,canvasHeight);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    // 设置成自己的数据
    private TwoWaysQuickSortData data;
    public void render(TwoWaysQuickSortData data) {
        this.data = data;
        repaint(); //重新画圆
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            //双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //抗锯齿 平滑
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            // 具体图形绘制
            int w = canvasHeight/data.N();
            for(int i=0;i<data.N();i++){
                if(i>=data.l && i<= data.r){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Green);
                } else {
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Grey);
                }

                if(i == data.curPivot){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Indigo);
                }
                if(i>=data.l+1 && i<=data.curL){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                }
                if(i>=data.curR && i<=data.r) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                }
                if(data.fixedPivots[i]){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);
                }

                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
