package br.edu.ifpb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.exceptions.*;
import br.edu.ifpb.interfaces.repository.*;
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
        String sql = "INSERT INTO rooms(id, number, number_of_beds, number_of_tvs, number_of_bathrooms, air_conditioning, suite, room_type_id, room_status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Room room : rooms) {
                pstmt.setInt(1, room.getRoomId().getValue());
                pstmt.setString(2, room.getNumber().toString());
                pstmt.setInt(3, room.getNumberOfBeds());
                pstmt.setInt(4, room.getNumberOfTvs());
                pstmt.setInt(5, room.getNumberOfBathrooms());
                pstmt.setBoolean(6, room.hasAirConditioning());
                pstmt.setBoolean(7, room.isSuite());
                pstmt.setInt(8, room.getRoomTypeId().getValue());
                pstmt.setString(9, room.getStatus().getValue());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Carrega as salas do banco de dados
    public void loadRoomsFromDB() {
        String sql = "SELECT id, number, number_of_beds, number_of_tvs, number_of_bathrooms, air_conditioning, suite, room_type_id, room_status FROM rooms";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            rooms.clear();

            while (rs.next()) {
                Id roomId = new Id(rs.getInt("id"));
                RoomNumber number = new RoomNumber(rs.getInt("number"));
                int numberOfBeds = rs.getInt("number_of_beds");
                int numberOfTvs = rs.getInt("number_of_tvs");
                int numberOfBathrooms = rs.getInt("number_of_bathrooms");
                boolean airConditioning = rs.getBoolean("air_conditioning");
                boolean suite = rs.getBoolean("suite");
                Id roomTypeId = new Id(rs.getInt("room_type_id"));
                RoomStatus status = RoomStatus.valueOf(rs.getString("room_status"));

                Room room = new Room.RoomBuilder()
                    .withNumber(number)
                    .withNumberOfBeds(numberOfBeds)
                    .withNumberOfTvs(numberOfTvs)
                    .withNumberOfBathrooms(numberOfBathrooms)
                    .withAirConditioning(airConditioning)
                    .withSuite(suite)
                    .withRoomTypeId(roomTypeId)
                    .withStatus(status)
                    .build();

                    room.setRoomId(roomId);

                rooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addRoom(Room room) {
        String checkSql = "SELECT COUNT(*) FROM rooms WHERE number = ?";
        String insertSql = "INSERT INTO rooms(id, number, number_of_beds, number_of_tvs, number_of_bathrooms, air_conditioning, suite, room_type_id, room_status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

            // Verifica se o número do quarto já existe no banco
            checkStmt.setString(1, room.getNumber().toString());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Quarto com esse número já existe no banco de dados.");
            } else {
                // Se não existir, insere novo quarto
                insertStmt.setInt(1, room.getRoomId().getValue());
                insertStmt.setString(2, room.getNumber().toString());
                insertStmt.setInt(3, room.getNumberOfBeds());
                insertStmt.setInt(4, room.getNumberOfTvs());
                insertStmt.setInt(5, room.getNumberOfBathrooms());
                insertStmt.setBoolean(6, room.hasAirConditioning());
                insertStmt.setBoolean(7, room.isSuite());
                insertStmt.setInt(8, room.getRoomTypeId().getValue());
                insertStmt.setString(9, room.getStatus().getValue());

                insertStmt.executeUpdate();
                rooms.add(room); // Adiciona à lista interna
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
                String sql = "UPDATE rooms SET number = ?, number_of_beds = ?, number_of_tvs = ?, number_of_bathrooms = ?, air_conditioning = ?, suite = ?, room_type_id = ?, room_status = ? WHERE id = ?";
                try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, updateRoom.getNumber().toString());
                    pstmt.setInt(2, updateRoom.getNumberOfBeds());
                    pstmt.setInt(3, updateRoom.getNumberOfTvs());
                    pstmt.setInt(4, updateRoom.getNumberOfBathrooms());
                    pstmt.setBoolean(5, updateRoom.hasAirConditioning());
                    pstmt.setBoolean(6, updateRoom.isSuite());
                    pstmt.setInt(7, updateRoom.getRoomTypeId().getValue());
                    pstmt.setString(8, updateRoom.getStatus().getValue());
                    pstmt.setInt(9, updateRoom.getRoomId().getValue());
                    pstmt.executeUpdate();
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
            } else {
                System.out.println("Nenhum quarto encontrado com o número informado.");
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
            if (room.getNumber().equals(roomNumber)) {
                return room;
            }
        }
        throw new RoomNotFoundException();
    }
}
