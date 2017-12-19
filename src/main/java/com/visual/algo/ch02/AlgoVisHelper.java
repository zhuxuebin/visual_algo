package com.visual.algo.ch02;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class AlgoVisHelper {

    private AlgoVisHelper(){
    }

    public static void drawCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }
}
