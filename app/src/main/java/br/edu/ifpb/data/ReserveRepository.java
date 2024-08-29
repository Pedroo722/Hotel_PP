package br.edu.ifpb.data;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.exceptions.*;
import br.edu.ifpb.db.*;

public class ReserveRepository implements ReserveRepositoryInterface {
    private static ReserveRepository instance;
    private List<Reserve> reserves;

    private ReserveRepository() {
        this.reserves = new ArrayList<>();
        DataBaseInitializer.initialize();
    }

    // Padrão de Criação: Singleton
    public static ReserveRepository getInstance() {
        if (instance == null) {
            instance = new ReserveRepository();
        }
        return instance;
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

    public void saveReservesToDB() {
        String sql = "INSERT INTO reserves(user_id, room_number, check_in, check_out, reserve_status) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Reserve reserve : reserves) {
                pstmt.setInt(1, reserve.getUserId().getValue());
                pstmt.setString(2, reserve.getNumber().toString());
                pstmt.setString(3, reserve.getCheckIn().toString());
                pstmt.setString(4, reserve.getCheckOut().toString());
                pstmt.setString(5, reserve.getStatus().toString());
                pstmt.executeUpdate();
            }
            System.out.println("All reserves have been saved to the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadReservesFromDB() {
        String sql = "SELECT id, user_id, room_number, check_in, check_out, reserve_status FROM reserves";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            reserves.clear(); 

            while (rs.next()) {
                Id reserveId = new Id(rs.getInt("id"));
                Id userId = new Id(rs.getInt("user_id"));

                String roomNumberStr = rs.getString("room_number");
                Integer roomNumberInt = Integer.parseInt(roomNumberStr);
                RoomNumber number = new RoomNumber(roomNumberInt);

                LocalDate checkIn = rs.getDate("check_in").toLocalDate();
                LocalDate checkOut = rs.getDate("check_out") != null ? rs.getDate("check_out").toLocalDate() : null;
                ReserveStatus status = ReserveStatus.valueOf(rs.getString("reserve_status"));

                Reserve reserve = new Reserve(userId, number);
                reserve.setReserveId(reserveId);
                reserve.setCheckIn(checkIn);
                reserve.setCheckOut(checkOut);
                reserve.setStatus(status);
                reserves.add(reserve);
            }

            System.out.println("Reserves loaded from the database.");
        } catch (SQLException e) {
            System.out.println("Error ao obter as Reservas do Banco: " + e.getMessage());
        }
    }

    @Override
    public void addReserve(Reserve reserve) {
        String sql = "INSERT INTO reserves(user_id, room_number, check_in, check_out, reserve_status) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserve.getUserId().getValue());
            pstmt.setString(2, reserve.getNumber().toString());
            pstmt.setString(3, reserve.getCheckIn().toString());

            if (reserve.getCheckOut() != null) {
                pstmt.setString(4, reserve.getCheckOut().toString());
            } else {
                pstmt.setString(4, "Nulo");
            }
            pstmt.setString(5, reserve.getStatus().toString());
            pstmt.executeUpdate();
            reserves.add(reserve);
            System.out.println("Reserve added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateReserve(Reserve updatedReserve) {
        String sql = "UPDATE reserves SET user_id = ?, room_number = ?, check_in = ?, check_out = ?, reserve_status = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, updatedReserve.getUserId().getValue());
            pstmt.setString(2, updatedReserve.getNumber().toString());
            pstmt.setString(3, updatedReserve.getCheckIn().toString());
            pstmt.setString(4, updatedReserve.getCheckOut().toString());
            pstmt.setString(5, updatedReserve.getStatus().toString());
            pstmt.setInt(6, updatedReserve.getReserveId().getValue());
            pstmt.executeUpdate();

            // Atualiza a lista interna
            for (int i = 0; i < reserves.size(); i++) {
                if (reserves.get(i).getReserveId().equals(updatedReserve.getReserveId())) {
                    reserves.set(i, updatedReserve);
                    System.out.println("Reserve updated successfully.");
                    return;
                }
            }
            throw new ReserveNotFoundException();
        } catch (SQLException e) {
            System.out.println("Error updating reserve: " + e.getMessage());
        }
    }

    @Override
    public void removeReserve(Id id) {
        String sql = "DELETE FROM reserves WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id.getValue());
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                reserves.removeIf(reserve -> reserve.getReserveId().equals(id));
                System.out.println("Reserve removed successfully.");
            } else {
                System.out.println("No reserve found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing reserve: " + e.getMessage());
        }
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    @Override
    public Reserve findReserveById(Id id) {
        for (Reserve reserve : reserves) {
            if (reserve.getReserveId().equals(id)) {
                return reserve;
            }
        }
        throw new ReserveNotFoundException();
    }
}
