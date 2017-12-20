package com.visual.algo.ch02;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class AlgoVisHelper {

    private AlgoVisHelper(){
    }

    //空心圆
    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    //实心圆
    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    //设置画笔粗细
    public static void setStroke(Graphics2D g2d, int strokeWidth) {
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    //设置颜色
    public static void setColor(Graphics2D g2d, Color color){
            g2d.setColor(color);
    }

    public static void sleep(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e){
            System.out.println("thread sleeping error...");
        }
    }

}
