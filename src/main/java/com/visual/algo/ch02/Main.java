package com.visual.algo.ch02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new AlgoFrame("welcome", 500, 500);
        });
    }
}
