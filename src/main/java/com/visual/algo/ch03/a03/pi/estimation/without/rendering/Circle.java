package com.visual.algo.ch03.a03.pi.estimation.without.rendering;

import java.awt.*;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class Circle {

    private int x; //圆心x轴
    private int y;
    private int r;

    private int vx; //圆x轴运动速度
    private int vy; //圆y轴运动速度

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean contain(Point point) {
        return Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2) <= r * r;
    }
}
