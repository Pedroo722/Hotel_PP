package br.edu.ifpb.db;

import java.sql.*;

public class DataBaseManager {
    private static final String URL = "jdbc:sqlite:meu_banco_de_dados.db";

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

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void printGuestsTableContents() {
        try (Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM guests";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nContents of table: guests");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");
                String status = rs.getString("guest_status");
                System.out.println("ID: " + id + ", Name: " + name + ", CPF: " + cpf + ", Guest Status: " + status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printReservesTableContents() {
        try (Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM reserves";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nContents of table: reserves");
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String roomNumber = rs.getString("room_number");
                String checkIn = rs.getString("check_in");
                String checkOut = rs.getString("check_out");
                String reserveStatus = rs.getString("reserve_status");
                System.out.println("ID: " + id + ", User ID: " + userId + ", Room Number: " + roomNumber 
                        + ", Check In: " + checkIn + ", Check Out: " + checkOut + ", Status: " + reserveStatus);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printRoomsTableContents() {
        try (Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM rooms";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nContents of table: rooms");
            while (rs.next()) {
                int id = rs.getInt("id");
                String number = rs.getString("number");
                int roomTypeId = rs.getInt("room_type_id");
                String roomStatus = rs.getString("room_status");
                System.out.println("ID: " + id + ", Number: " + number + ", Room Type ID: " + roomTypeId 
                        + ", Room Status: " + roomStatus);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printRoomTypesTableContents() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM room_types";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nContents of table: room_types");
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int capacity = rs.getInt("capacity");
                String typeName = rs.getString("type_name");
                System.out.println("ID: " + id + ", Description: " + description + ", Capacity: " + capacity 
                        + ", Type Name: " + typeName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
