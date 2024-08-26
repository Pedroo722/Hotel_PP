package br.edu.ifpb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.*;
import br.edu.ifpb.exceptions.*;
import br.edu.ifpb.domain.wrappers.*;

public class RoomRepository implements RoomRepositoryInterface {
    private static RoomRepository instance;
    private List<Room> rooms = new ArrayList<>();

    private RoomRepository() {
        this.rooms = new ArrayList<>();
        loadRoomsFromDB();
    }

    // Padrão de Criação: Singleton
    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }

    // Conexão com o banco
    private Connection connect() {
        String url = "jdbc:sqlite:meu_banco_de_dados.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Salva as salas no banco de dados
    public void saveRoomsToDB() {
        String sql = "INSERT INTO rooms(id, number, room_type_id, room_status) VALUES(?, ?, ?, ?)"; 

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Room room : rooms) {
                pstmt.setInt(1, room.getRoomId().getValue());
                pstmt.setString(2, room.getNumber().toString());
                pstmt.setInt(3, room.getRoomTypeId().getValue());
                pstmt.setInt(4, room.getStatus().getValue());  
                pstmt.executeUpdate();
            }
            System.out.println("All rooms have been saved to the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Carrega as salas do banco de dados
    public void loadRoomsFromDB() {
        String sql = "SELECT id, number, room_type_id, room_status FROM rooms"; 
    
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            rooms.clear();
    
            while (rs.next()) {
                Id roomId = new Id(rs.getInt("id"));
                RoomNumber number = new RoomNumber(rs.getInt("number"));
                RoomType type = RoomType.getRoomTypeFromId(rs.getInt("room_type_id")); 
    
                int statusValue = rs.getInt("room_status");
                RoomStatus status;
    
                switch (statusValue) {
                    case 1:
                        status = RoomStatus.AVAILABLE;
                        break;
                    case 2:
                        status = RoomStatus.OCCUPIED;
                        break;
                    default:
                        System.err.println("Unexpected status value: " + statusValue);
                        status = RoomStatus.AVAILABLE; 
                        break;
                }
    
                Room room = new Room.RoomBuilder()
                    .withRoomTypeId(type.getRoomTypeId())
                    .withNumber(number)
                    .withStatus(status)
                    .build();
    
                room.setRoomId(roomId);
    
                rooms.add(room);
            }
    
            System.out.println("Rooms loaded from the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    @Override
    public void addRoom(Room room) {
        String checkSql = "SELECT COUNT(*) FROM rooms WHERE number = ?";
        String insertSql = "INSERT INTO rooms(id, number, room_type_id, room_status) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

            // Verifica se o número do quarto já existe no banco
            checkStmt.setString(1, room.getNumber().toString());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Room with this number already exists in the database.");
            } else {
                // Se não existir, insere novo quarto
                insertStmt.setInt(1, room.getRoomId().getValue());
                insertStmt.setString(2, room.getNumber().toString());
                insertStmt.setInt(3, room.getRoomTypeId().getValue()); 
                insertStmt.setInt(4, room.getStatus().getValue()); 
                
                insertStmt.executeUpdate();
                rooms.add(room); // Adiciona à lista interna
                System.out.println("Room added successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRoom(Room updateRoom) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getRoomId().equals(updateRoom.getRoomId())) {
                // Atualiza lista interna
                rooms.set(i, updateRoom);
                // Atualiza banco de dados
                String sql = "UPDATE rooms SET number = ?, room_type_id = ? WHERE id = ?";
                try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, updateRoom.getNumber().toString());
                    pstmt.setInt(2, updateRoom.getRoomTypeId().getValue()); 
                    pstmt.setInt(3, updateRoom.getRoomId().getValue());
                    pstmt.executeUpdate();
                    System.out.println("Room updated successfully.");
                } catch (SQLException e) {
                    System.out.println("Error updating room: " + e.getMessage());
                }
                return;
            }
        }
        throw new RoomNotFoundException();
    }

    public void removeRoom(RoomNumber roomNumber) {
        String deleteSql = "DELETE FROM rooms WHERE number = ?";

        try (Connection conn = this.connect();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {

            deleteStmt.setString(1, roomNumber.toString());

            int affectedRows = deleteStmt.executeUpdate();

            if (affectedRows > 0) {
                rooms.removeIf(room -> room.getNumber().equals(roomNumber));
                System.out.println("Room removed successfully.");
            } else {
                System.out.println("No room found with the provided number.");
            }

        } catch (SQLException e) {
            System.out.println("Error removing room: " + e.getMessage());
        }
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public Room findRoomByNumber(RoomNumber roomNumber) {
        for (Room room : rooms) {
            if (CheckRoomIdentityUseCase.isSameRoom(room, roomNumber)) {
                return room;
            }
        }
        throw new RoomNotFoundException();
    }
}
