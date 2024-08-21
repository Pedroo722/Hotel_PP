package br.edu.ifpb.data;

import java.io.*;
import java.util.*;

import br.edu.ifpb.domain.cases.GuestUseCase.CheckGuestIdentityUseCase;
import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.exceptions.GuestNotFoundException;

import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GuestRepository implements GuestRepositoryInterface, Serializable {
    private static GuestRepository instance;
    private List<Guest> guests;

    private GuestRepository() {
        this.guests = new ArrayList<>();
    }

    // Padrão de Criação: Singleton
    public static GuestRepository getInstance() {
        if (instance == null) { instance = new GuestRepository(); }
        return instance;
    }

    // Metodo para salvar Guests no Banco de Dados
    // public void saveGuestsToFile() {
    //     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin", true))) {
    //         out.writeObject(this.guests);
    //         System.out.println("Serialized data is saved in Guests.bin");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // Metodo para retirar os Guests do Banco de Dados
    // public void loadGuestsFromFile() {
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Guests.bin"))) {
    //         this.guests = (List<Guest>) ois.readObject();
    //         System.out.println("Guests loaded from Guests.bin");
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Guests file not found. Creating new guest list.");
    //         this.guests = new ArrayList<>();
    //     } catch (IOException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    // }

    //Coneção com o banco
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
        String sql = "INSERT INTO guests(name, cpf) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guest.toString());
            pstmt.setString(2, guest.getCpf());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Queria rodar essa criação de tabela em algum lugar, mas não sei onde
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
    //RAMONNNNNNNNN


//    public void addGuest(Guest guest) {
//        guests.add(guest);
//        // saveGuestsToFile();
//    }

    public void updateGuest(Guest updatedGuest) {
        for (int i = 0; i < guests.size(); i++) {
            Guest guest = guests.get(i);
            if (guest.getUserId().equals(updatedGuest.getUserId())) {
                guests.set(i, updatedGuest);
                // saveGuestsToFile();
                return;
            }
        }
        throw new GuestNotFoundException();
    }

    public void removeGuest(Id id) {
        guests.removeIf(guest -> guest.getUserId().equals(id));
        // saveGuestsToFile();
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
