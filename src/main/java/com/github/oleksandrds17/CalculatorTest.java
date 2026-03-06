package com.github.oleksandrds17;

public class CalculatorTest {

    @Test
    public void testAddition() {

        int a = 5;
        int b = 3;

        if (a + b != 8) {
            throw new RuntimeException("Addition failed");
        }

        System.out.println("Addition OK");
    }

    @Test
    public void testMultiplication() {

        int a = 4;
        int b = 3;

        if (a * b != 12) {
            throw new RuntimeException("Multiplication failed");
        }

        System.out.println("Multiplication OK");
    }

    public void helper() {
        System.out.println("Not a test");
    }
}