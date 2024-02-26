package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.GuestIF;

public class Guest implements GuestIF {
    private int userId;
    private String name, password, cpf;

    public Guest(String name, String password, String cpf) {
        this.name = name;
        this.password = password;
        this.cpf = cpf;
    };

    public Guest returnGuest(int userId) {
        if (this.userId == userId) {
            return this;
        } 
        
        return null;
    }

    public void updateGuest(Guest guest, String newName, String newPassword, String newCpf) {
        guest.name = newName;
        guest.password = newPassword;
        guest.cpf = newCpf;
    }
    
}
