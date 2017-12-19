package com.visual.algo.ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        setContentPane(new AlgoCanvas()); //JFrame相当于画板，JPanel相当于画布（中间介质）
        pack(); //根据子组件preferredSize等属性自动调节窗口大小

//        setSize(canvasWidth,canvasHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
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


            int strokeWidth = 5;
            g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            g2d.setColor(Color.RED);
            AlgoVisHelper.drawCircle(g2d, canvasWidth/2, canvasHeight/2, 200);

            g2d.setColor(Color.BLUE);
            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
