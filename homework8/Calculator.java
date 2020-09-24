package com.company.brik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    public Calculator() {
        setBounds(500,500,400,300);
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[10];
        setLayout(new GridLayout(4, 3));
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("" + i);
            add(jbs[i]);
        }
        setVisible(true);
    }
}
