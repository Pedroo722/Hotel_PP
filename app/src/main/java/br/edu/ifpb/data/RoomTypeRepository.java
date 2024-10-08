package br.edu.ifpb.data;

import java.sql.*;
import java.util.*;

import br.edu.ifpb.domain.cases.RoomTypeUseCase.CheckRoomTypeIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class RoomTypeRepository {
    private static RoomTypeRepository instance;
    private List<RoomType> roomTypes;

    private RoomTypeRepository() {
        this.roomTypes = new ArrayList<>();
        loadRoomTypesFromDB();
    }

    // Padrão de Criação: Singleton
    public static RoomTypeRepository getInstance() {
        if (instance == null) {
            instance = new RoomTypeRepository();
        }
        return instance;
    }

    public void saveRoomTypesToDB() {
        String sql = "INSERT INTO room_types(id, description, capacity, type_name) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (RoomType roomType : roomTypes) {
                pstmt.setInt(1, roomType.getRoomTypeId().getValue());
                pstmt.setString(2, roomType.getDescription().getDescription());
                pstmt.setInt(3, roomType.getCapacity().getValue());
                pstmt.setString(4, roomType.getTypeName());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadRoomTypesFromDB() {
        String sql = "SELECT id, description, capacity, type_name FROM room_types";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            roomTypes.clear(); 

            while (rs.next()) {
                String typeName = rs.getString("type_name");
    
                System.out.println("Tipo de Quarto: " + typeName);
                RoomType roomType = RoomTypeFactory.createRoomType(typeName);
                roomTypes.add(roomType);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public void addRoomType(RoomType roomType) {
        String insertSql = "INSERT INTO room_types(description, capacity, type_name) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            insertStmt.setString(1, roomType.getDescription().getDescription());
            insertStmt.setInt(2, roomType.getCapacity().getValue());
            insertStmt.setString(3, roomType.getTypeName());
            insertStmt.executeUpdate();
            roomTypes.add(roomType);
        } catch (SQLException e) {
            System.out.println("Error ao adicionar um Tipo de Quarto: " + e.getMessage());
        }
    }

    public void removeRoomType(Id id) {
        String deleteSql = "DELETE FROM room_types WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {

            deleteStmt.setInt(1, id.getValue());

            int affectedRows = deleteStmt.executeUpdate();

            if (affectedRows > 0) {
                roomTypes.removeIf(roomType -> roomType.getRoomTypeId().equals(id));
            } else {
                System.out.println("Tipo de Quarto não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error removing room type: " + e.getMessage());
        }
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public RoomType findRoomTypeById(Id id) {
        for (RoomType roomType : roomTypes) {
            if (CheckRoomTypeIdentityUseCase.isSameRoomType(roomType, id)) {
                return roomType;
            }
        }
        throw new RuntimeException("Room type not found.");
    }
}
