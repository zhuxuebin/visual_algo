package com.visual.algo.ch03.a03.pi.estimation.without.rendering;

import java.awt.*;

/**
 * Created by xuery on 2017/12/21.
 */
public class MonteCarloExperiment {

    private int squareSide; //正方形长
    private int outInterval; //每跑多少次输出一次
    private int N;

    public MonteCarloExperiment(int squareSide, int outInterval, int N) {
        this.squareSide = squareSide;
        this.outInterval = outInterval;
        this.N = N;
    }

    public void run() {
        MonteCarloPiData piData = new MonteCarloPiData(new Circle(squareSide / 2, squareSide / 2, squareSide / 2));
        for (int i = 0; i < N; i++) {
            if (i % outInterval == 0) {
                System.out.println(piData.estimatePi());
            }
            int x = (int)(Math.random()*squareSide);
            int y = (int)(Math.random()*squareSide);
            piData.addPoint(new Point(x,y));
        }
    }

    public static void main(String[] args) {
        MonteCarloExperiment experiment = new MonteCarloExperiment(800,10000,10000000);
        experiment.run();
    }
}
