package com.github.oleksandrds17;


import javax.swing.*;

public class TestGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reflection Test Runner");

        JButton button = new JButton("Run Tests");

        button.addActionListener(e -> {
            TestRunner.runTests(CalculatorTest.class);
        });

        frame.add(button);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
