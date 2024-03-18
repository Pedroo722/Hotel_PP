package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.GuestIF;
import br.edu.ifpb.wrappers.*;

public class Guest implements GuestIF {
    private final Id userId;
    private final Name name;
    private final CPF cpf;
    private final GuestStatus isHosted;
    private final RoomNumber roomNumber;

    public Guest(Name name , CPF cpf, GuestStatus isHosted, RoomNumber roomNumber) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.isHosted = isHosted;
        this.roomNumber = roomNumber;
    }

    public boolean isSameGuest(Id userId) {
        return this.userId.equals(userId);
    }

    public Guest updateGuest(Name newName, CPF newCpf, GuestStatus isHosted, RoomNumber roomNumber) {
        return new Guest(newName, newCpf, isHosted, roomNumber);
    }

    public void registerGuest(Id guestId) {
        
    }

    public void cancelRegistration(Id userId) {

    }
 

}
