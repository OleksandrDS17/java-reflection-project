package com.github.oleksandrds17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/testdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static void saveResult(String testName, String result) {
        String sql = "INSERT INTO test_results(test_name, result) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, testName);
            stmt.setString(2, result);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> getResults() {
        List<String[]> results = new ArrayList<>();

        String sql = "SELECT id, test_name, result, run_time FROM test_results ORDER BY id DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[4];
                row[0] = String.valueOf(rs.getInt("id"));
                row[1] = rs.getString("test_name");
                row[2] = rs.getString("result");
                row[3] = rs.getTimestamp("run_time").toString();
                results.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void clearResults() {
        String sql = "DELETE FROM test_results";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}