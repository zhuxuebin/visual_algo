package com.visual.algo.ch02;

import java.awt.*;

/**
 * Created by 01368080 on 2017/12/20.
 */
public class Circle {

    public int x; //圆心x轴
    public int y; //圆心y轴
    public boolean isFilled;
    private int r;

    private int vx; //圆x轴运动速度
    private int vy; //圆y轴运动速度

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR(){
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy){
        x += vx;
        y += vy;

        checkCollision(minx, miny, maxx, maxy);
    }
    private void checkCollision(int minx, int miny , int maxx, int maxy){
        if(x - r < minx){ x = r; vx = -vx;}
        if(x + r >= maxx){ x = maxx-r; vx = -vx;}
        if(y - r < miny){ y = r; vy = -vy;}
        if(y + r >= maxy){ y = maxy-r; vy = -vy;}
    }

    public boolean contain(Point point){
        return (x-point.x)*(x-point.x)+(y-point.y)*(y-point.y) <= r*r;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"x\":")
                .append(x);
        sb.append(",\"y\":")
                .append(y);
        sb.append(",\"r\":")
                .append(r);
        sb.append(",\"vx\":")
                .append(vx);
        sb.append(",\"vy\":")
                .append(vy);
        sb.append('}');
        return sb.toString();
    }
}
