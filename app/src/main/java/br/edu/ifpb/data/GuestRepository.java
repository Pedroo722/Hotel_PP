package br.edu.ifpb.data;

import java.util.*;

import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;

public class GuestRepository implements GuestRepositoryInterface {
    private static GuestRepository instance;
    private List<Guest> guests;

    private GuestRepository() {
        this.guests = new ArrayList<>();
        loadGuestsFromDB();
    }

    // Padrão de Criação: Singleton
    public static GuestRepository getInstance() {
        if (instance == null) {
            instance = new GuestRepository();
        }
        return instance;
    }

    public void saveGuestsToDB() {
        String sql = "INSERT INTO guests(name, cpf, guest_status) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Guest guest : guests) {
                pstmt.setString(1, guest.getName().toString());
                pstmt.setString(2, guest.getCpf().toString());
                pstmt.setString(3, guest.getStatus().getValue());
                pstmt.executeUpdate();
            }
            System.out.println("All guests have been saved to the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadGuestsFromDB() {
        String sql = "SELECT id, name, cpf, guest_status FROM guests";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            guests.clear(); 

            while (rs.next()) {
                Id userId = new Id(rs.getInt("id"));
                Name name = new Name(rs.getString("name"));
                CPF cpf = new CPF(rs.getString("cpf"));
                GuestStatus status = GuestStatus.valueOf(rs.getString("guest_status"));

                Guest guest = new Guest(name, cpf, status);
                
                guest.setUserId(userId);
                guests.add(guest);
            }

            System.out.println("Guests loaded from the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Coneção com o banco
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

    @Override
    public void addGuest(Guest guest) {
        String checkSql = "SELECT COUNT(*) FROM guests WHERE cpf = ?";
        String insertSql = "INSERT INTO guests(id, name, cpf, guest_status) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            
            // Verifica se o CPF já existe no banco
            checkStmt.setString(1, guest.getCpf().toString());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Hóspede com este CPF já existe no banco de dados.");
            } else {
                // Se não existir, tem que inserir novo hóspede
                insertStmt.setInt(1, guest.getUserId().getValue());
                insertStmt.setString(2, guest.getName().toString());
                insertStmt.setString(3, guest.getCpf().toString());
                insertStmt.setString(4, guest.getStatus().getValue());
                insertStmt.executeUpdate();
                guests.add(guest);  // Adiciona à lista interna
                System.out.println("Hóspede adicionado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    ///// TÁ ERRADO
    @Override
    public void updateGuest(Guest updatedGuest) {
        for (int i = 0; i < guests.size(); i++) {
            Guest guest = guests.get(i);
            if (guest.getUserId().equals(updatedGuest.getUserId())) {
                // Atualiza lista interna
                guests.set(i, updatedGuest);
                // Atualiza banco de dados
                String sql = "UPDATE guests SET name = ?, cpf = ?, guest_status = ? WHERE id = ?";
                try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, updatedGuest.getName().toString());
                    pstmt.setString(2, updatedGuest.getCpf().toString());
                    pstmt.setInt(3, updatedGuest.getUserId().getValue());
                    pstmt.setString(4, updatedGuest.getStatus().getValue());
                    pstmt.executeUpdate();
                    System.out.println("Hóspede atualizado com sucesso.");
                } catch (SQLException e) {
                    System.out.println("Erro ao atualizar hóspede: " + e.getMessage());
                }
                return;
            }
        }
        throw new GuestNotFoundException();
    }

    public void removeGuest(Id id) {
        String deleteSql = "DELETE FROM guests WHERE id = ?";
    
        try (Connection conn = this.connect();
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
             
            // Configura o ID para o PreparedStatement
            deleteStmt.setInt(1, id.getValue());
            
            // Executa a operação de deletar
            int affectedRows = deleteStmt.executeUpdate();
            
            if (affectedRows > 0) {
                // Remove da lista interna se a remoção no banco de dados foi bem-sucedida
                guests.removeIf(guest -> guest.getUserId().equals(id));
                System.out.println("Hóspede removido com sucesso.");
            } else {
                System.out.println("Nenhum hóspede encontrado com o ID fornecido.");
            }
    
        } catch (SQLException e) {
            System.out.println("Erro ao remover hóspede: " + e.getMessage());
        }
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public Guest findGuestById(Id id) {
        for (Guest guest : guests) {
            if (CheckGuestIdentityUseCase.isSameGuest(guest, id)) {
                return guest;
            }
        }
        throw new GuestNotFoundException();
    }
}
