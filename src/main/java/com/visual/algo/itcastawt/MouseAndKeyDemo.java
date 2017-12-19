package com.visual.algo.itcastawt;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by 01368080 on 2017/12/19.
 */
public class MouseAndKeyDemo {

    private Frame f;
    private TextField tf;
    private Button but;

    public MouseAndKeyDemo() {
        init();
    }

    private void init(){
        f = new Frame("演示鼠标和键盘监听");
        f.setBounds(400,200,400,500);
        f.setLayout(new FlowLayout());

        tf = new TextField(35);
        but = new Button("一个按钮");

        f.add(tf);
        f.add(but);

        myEvent();

        f.setVisible(true);
    }

    private void myEvent(){
        //给文本添加键盘监听
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER){
                    System.out.println("enter run ...");
                }
            }
        });

        //点击关闭按钮，关闭窗口事件监听
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        but.addMouseListener(new MouseAdapter() {
            private int count = 1;
            @Override
            public void mouseClicked(MouseEvent e) {
                if( e.getClickCount() == 2){
                    tf.setText("mouse double click..."+count++);
                }
            }
        });
    }

    public static void main(String[] args) {
        new MouseAndKeyDemo();
    }
}
