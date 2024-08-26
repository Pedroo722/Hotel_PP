package br.edu.ifpb.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInitializer {

    public static void initialize() {
        String sqlGuests = "CREATE TABLE IF NOT EXISTS guests (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " cpf TEXT NOT NULL UNIQUE\n"
                + ");";
        
        String sqlReserves = "CREATE TABLE IF NOT EXISTS reserves (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " user_id INTEGER NOT NULL,\n"
                + " room_number TEXT NOT NULL,\n"
                + " check_in DATE NOT NULL,\n"
                + " check_out DATE,\n"
                + " status TEXT NOT NULL,\n"
                + " FOREIGN KEY(user_id) REFERENCES guests(id)\n"
                + ");";
        
        String sqlRooms = "CREATE TABLE IF NOT EXISTS rooms (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " number TEXT NOT NULL UNIQUE,\n"
                + " room_type_id INTEGER NOT NULL,\n"
                + " status TEXT NOT NULL,\n"
                + " FOREIGN KEY(room_type_id) REFERENCES roomtypes(id)\n"
                + ");";
        
        String sqlRoomTypes = "CREATE TABLE IF NOT EXISTS roomtypes (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " description TEXT NOT NULL,\n"
                + " capacity INTEGER NOT NULL,\n"
                + " type_name TEXT NOT NULL\n"
                + ");";

        try (Connection conn = DataBaseManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlGuests);
            stmt.execute(sqlReserves);
            stmt.execute(sqlRooms);
            stmt.execute(sqlRoomTypes);
            System.out.println("Tables 'guests', 'reserves', 'rooms', and 'roomtypes' have been created or already exist.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printTableContents() {
        String[] tables = {"guests", "reserves", "rooms", "roomtypes"};

        try (Connection conn = DataBaseManager.connect();
             Statement stmt = conn.createStatement()) {

            for (String table : tables) {
                System.out.println("\nContents of table: " + table);
                String sql = "SELECT * FROM " + table;
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    // Adjust this according to your table structure
                    StringBuilder row = new StringBuilder();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        row.append(rs.getString(i)).append(" ");
                    }
                    System.out.println(row.toString());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
