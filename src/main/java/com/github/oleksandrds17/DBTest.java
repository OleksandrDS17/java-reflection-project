package com.github.oleksandrds17;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {

    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testdb",
                "postgres",
                "password"
        );

        System.out.println("Connected to database!");

        conn.close();
    }
}