package br.edu.ifpb.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInitializer {

    public static void initialize() {
        String sqlGuests = "CREATE TABLE IF NOT EXISTS guests (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " cpf TEXT NOT NULL UNIQUE,\n"
                + " guest_status TEX,T\n"
                + ");";
        
        String sqlReserves = "CREATE TABLE IF NOT EXISTS reserves (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " user_id INTEGER NOT NULL,\n"
                + " room_number TEXT NOT NULL,\n"
                + " check_in DATE NOT NULL,\n"
                + " check_out DATE,\n"
                + " reserve_status TEXT,\n"
                + " FOREIGN KEY(user_id) REFERENCES guests(id)\n"
                + ");";

        String sqlRooms = "CREATE TABLE IF NOT EXISTS rooms (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " number TEXT NOT NULL UNIQUE,\n"
                + " room_type_id INTEGER NOT NULL,\n"
                + " room_status TEXT,\n"
                + " FOREIGN KEY(room_type_id) REFERENCES roomtypes(id)\n"
                + ");";
        
        String sqlRoomTypes = "CREATE TABLE IF NOT EXISTS room_types (\n"
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
}
