package com.github.oleksandrds17;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {

    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                DatabaseConfig.URL,
                DatabaseConfig.USER,
                DatabaseConfig.PASSWORD
        );

        System.out.println("Connected to database!");

        conn.close();
    }
}