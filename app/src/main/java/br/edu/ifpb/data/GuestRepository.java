package br.edu.ifpb.data;

import java.io.*;
import java.util.*;

import br.edu.ifpb.db.*;
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

public class GuestRepository implements GuestRepositoryInterface, Serializable {
    private static GuestRepository instance;
    private List<Guest> guests;

    private GuestRepository() {
        this.guests = new ArrayList<>();
        DataBaseInitializer.initialize();
    }

    // Padrão de Criação: Singleton
    public static GuestRepository getInstance() {
        if (instance == null) {
            instance = new GuestRepository();
        }
        return instance;
    }

    public void saveGuestsToDB() {
        String sql = "INSERT INTO guests(name, cpf) VALUES(?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Guest guest : guests) {
                pstmt.setString(1, guest.getName().toString());
                pstmt.setString(2, guest.getCpf().toString());
                pstmt.executeUpdate();
            }
            System.out.println("All guests have been saved to the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadGuestsFromDB() {
        String sql = "SELECT id, name, cpf FROM guests";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            guests.clear(); 

            while (rs.next()) {
                Id userId = new Id(rs.getInt("id"));
                Name name = new Name(rs.getString("name"));
                CPF cpf = new CPF(rs.getString("cpf"));

                Guest guest = new Guest(userId, name, cpf); 
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
        guests.add(guest); 
    }

    // Método para criar a tabela de hóspedes
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS guests (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " cpf integer\n"
                + ");";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGuest(Guest updatedGuest) {
        for (int i = 0; i < guests.size(); i++) {
            Guest guest = guests.get(i);
            if (guest.getUserId().equals(updatedGuest.getUserId())) {
                guests.set(i, updatedGuest);
                // saveGuestsToDB();
                return;
            }
        }
        throw new GuestNotFoundException();
    }

    public void removeGuest(Id id) {
        guests.removeIf(guest -> guest.getUserId().equals(id));
        // saveGuestsToDB();
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
