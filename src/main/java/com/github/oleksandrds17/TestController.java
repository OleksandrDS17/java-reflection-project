package com.github.oleksandrds17;

import java.util.List;

public class TestController {

    public void runCalculatorTests() {
        TestRunner.runTests(CalculatorTest.class);
    }

    public List<String[]> loadResults() {
        return DatabaseManager.getResults();
    }

    public void clearResults() {
        DatabaseManager.clearResults();
    }
}