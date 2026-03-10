
package com.github.oleksandrds17;

public class DatabaseConfig {

    public static final String URL =
            System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:5432/testdb");

    public static final String USER =
            System.getenv().getOrDefault("DB_USER", "postgres");

    public static final String PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "password");

    private DatabaseConfig() {
    }
}