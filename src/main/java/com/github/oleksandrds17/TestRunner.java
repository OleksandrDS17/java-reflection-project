package com.github.oleksandrds17;

import java.lang.reflect.Method;

public class TestRunner {

    public static void runTests(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Method[] methods = clazz.getDeclaredMethods();

            int passed = 0;
            int failed = 0;

            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        method.invoke(instance);
                        passed++;
                        DatabaseManager.saveResult(method.getName(), "PASSED");
                    } catch (Exception e) {
                        failed++;
                        DatabaseManager.saveResult(method.getName(), "FAILED");
                        System.out.println("Test failed: " + method.getName());
                    }
                }
            }

            System.out.println("----------------");
            System.out.println("Passed: " + passed);
            System.out.println("Failed: " + failed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}