package com.visual.algo.ch03.a02.monte.carlo.simulation;

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

    // 设置成自己的数据
    private MonteCarloPiData piData;

    public void render(MonteCarloPiData piData) {
        this.piData = piData;
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

            //具体图形绘制
            Circle circle = piData.getCircle();
            AlgoVisHelper.setStroke(g2d, 3);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());

            for (int i = 0; i < piData.getPointNumber(); i++) {
                Point p = piData.getPoint(i);
                if (circle.contain(p)) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                } else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
                }
                AlgoVisHelper.fillCircle(g2d, p.x, p.y, 3);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
