package com.visual.algo.ch03.a04.three.gates.problem;

/**
 * Created by xuery on 2017/12/21.
 * 三门问题模拟
 */
public class ThreeGatesExperiment {

    private int N;

    public ThreeGatesExperiment(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be larger than 0");
        }
        this.N = N;
    }

    public void run(boolean isChange) {
        int win = 0;
        for (int i = 0; i < N; i++) {
            int rightGate = (int) (Math.random() * 3);
            int chooseGate = (int) (Math.random() * 3);
            if ((rightGate == chooseGate && !isChange) || (rightGate != chooseGate && isChange)) {
                win++;
            }
        }
        System.out.println((isChange?"change ":"not change ")+(double)win/N);
    }

    public static void main(String[] args) {
        int N = 10000;
        ThreeGatesExperiment experiment = new ThreeGatesExperiment(N);
        experiment.run(true);
    }
}
