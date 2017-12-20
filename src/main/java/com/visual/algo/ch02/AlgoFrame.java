package com.visual.algo.ch02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;
    private Circle[] circles;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
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

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void render(Circle[] circles) {
        this.circles = circles;
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


            AlgoVisHelper.setStroke(g2d, 2);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                if (circle.isFilled) {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }

//            AlgoVisHelper.setColor(g2d, Color.BLUE);
//            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
