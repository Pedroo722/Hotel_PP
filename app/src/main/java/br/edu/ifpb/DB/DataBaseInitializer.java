package br.edu.ifpb.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInitializer {

    public static void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS guests (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " cpf TEXT NOT NULL UNIQUE\n"
                + ");";

        try (Connection conn = DataBaseManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'guests' has been created or already exists.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
