package com.visual.algo.itcastawt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class FrameDemo {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setBounds(400,200,500,400);
        f.setLayout(new FlowLayout());

        Button but = new Button("一个按钮");
        f.add(but);

        f.addWindowListener(new WindowAdapter() {
            //监听窗口关闭事件
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("window closing "+e);
                System.exit(0);
            }
        });

        //在按钮上加上一个监听
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button run ...");
                System.exit(0);
            }
        });

        f.setVisible(true);
        System.out.println("over");
    }
}
