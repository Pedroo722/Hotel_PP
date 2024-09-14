package br.edu.ifpb.data;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;
import br.edu.ifpb.interfaces.repository.ReserveRepositoryInterface;

public class ReserveRepository implements ReserveRepositoryInterface {
    private static ReserveRepository instance;
    private List<Reserve> reserves;

    private ReserveRepository() {
        this.reserves = new ArrayList<>();
        loadReservesFromDB();
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
        String sql = "INSERT INTO reserves(id, user_id, room_number, service_id, check_in, check_out, reserve_status) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Reserve reserve : reserves) {
                pstmt.setInt(1, reserve.getReserveId().getValue());
                pstmt.setInt(2, reserve.getUserId().getValue());
                pstmt.setString(3, reserve.getNumber().toString());
                pstmt.setInt(4, reserve.getServiceId().getValue()); 
                pstmt.setString(5, reserve.getCheckIn().toString());
                pstmt.setString(6, reserve.getCheckOut() != null ? reserve.getCheckOut().toString() : "Nulo");
                pstmt.setString(7, reserve.getStatus().toString());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadReservesFromDB() {
        String sql = "SELECT id, user_id, room_number, service_id, check_in, check_out, reserve_status FROM reserves";
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            reserves.clear(); 
    
            while (rs.next()) {
                try {
                    Id reserveId = new Id(rs.getInt("id"));
                    Id userId = new Id(rs.getInt("user_id"));
                    Id serviceId = new Id(rs.getInt("service_id"));
    
                    String roomNumberStr = rs.getString("room_number");
                    Integer roomNumberInt = Integer.parseInt(roomNumberStr);
                    RoomNumber number = new RoomNumber(roomNumberInt);
    
                    LocalDate checkIn = LocalDate.parse(rs.getString("check_in"), formatter);
    
                    // Verifica se check_out é "Nulo" ou null, e trata adequadamente
                    String checkOutStr = rs.getString("check_out");
                    LocalDate checkOut = (checkOutStr != null && !checkOutStr.equalsIgnoreCase("Nulo")) 
                                          ? LocalDate.parse(checkOutStr, formatter) 
                                          : null;
    
                    ReserveStatus status = ReserveStatus.valueOf(rs.getString("reserve_status"));
    
                    Reserve reserve = new Reserve(reserveId, userId, number, serviceId, checkIn, checkOut, status);
                    reserves.add(reserve);
                } catch (DateTimeParseException e) {
                    System.out.println("Erro ao converter data: " + e.getMessage());
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error ao obter as Reservas do Banco: " + e.getMessage());
        }
    }    


    @Override
    public void addReserve(Reserve reserve) {
        String sql = "INSERT INTO reserves(id, user_id, room_number, service_id, check_in, check_out, reserve_status) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserve.getReserveId().getValue());
            pstmt.setInt(2, reserve.getUserId().getValue());
            pstmt.setString(3, reserve.getNumber().toString());
            pstmt.setInt(4, reserve.getServiceId().getValue());
            pstmt.setString(5, reserve.getCheckIn().toString());

            if (reserve.getCheckOut() != null) {
                pstmt.setString(6, reserve.getCheckOut().toString());
            } else {
                pstmt.setString(6, "Nulo");
            }
            pstmt.setString(7, reserve.getStatus().toString());
            pstmt.executeUpdate();
            reserves.add(reserve);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateReserve(Reserve updatedReserve) {
        String sql = "UPDATE reserves SET user_id = ?, room_number = ?, service_id = ?, check_in = ?, check_out = ?, reserve_status = ? WHERE id = ?";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, updatedReserve.getUserId().getValue());
            pstmt.setString(2, updatedReserve.getNumber().toString());
            pstmt.setInt(3, updatedReserve.getServiceId().getValue());
            pstmt.setString(4, updatedReserve.getCheckIn().toString());
            pstmt.setString(5, updatedReserve.getCheckOut() != null ? updatedReserve.getCheckOut().toString() : "Nulo");
            pstmt.setString(6, updatedReserve.getStatus().toString());
            pstmt.setInt(7, updatedReserve.getReserveId().getValue());
            pstmt.executeUpdate();

            // Atualiza a lista interna
            for (int i = 0; i < reserves.size(); i++) {
                if (reserves.get(i).getReserveId().equals(updatedReserve.getReserveId())) {
                    reserves.set(i, updatedReserve);
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
            } else {
                System.out.println("Reserva com o ID informado não encontrada.");
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
