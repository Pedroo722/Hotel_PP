package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.GuestIF;
import br.edu.ifpb.wrappers.*;

public class Guest implements GuestIF {
    private final Id userId;
    private final Name name;
    private final CPF cpf;
    private final GuestStatus status;
    private final RoomNumber roomNumber;

    public Guest(Name name , CPF cpf, GuestStatus status, RoomNumber roomNumber) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.roomNumber = roomNumber;
    }

    public boolean isSameGuest(Id userId) {
        return this.userId.equals(userId);
    }

    public Guest updateGuest(Name newName, CPF newCpf, GuestStatus status, RoomNumber roomNumber) {
        return new Guest(newName, newCpf, status, roomNumber);
    }

    public void updateStatus(boolean newStatus) {
        status.updateStatus(newStatus);
    }

    public boolean isHosted() {
        return status.isHosted();
    }
}