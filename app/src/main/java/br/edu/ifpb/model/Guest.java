package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.GuestIF;
import br.edu.ifpb.wrappers.*;

public class Guest implements GuestIF {
    private final Id userId;
    private final Name name;
    private final CPF cpf;
    private final GuestStatus status;
    private final Id reserveId;

    public Guest(Name name, CPF cpf, GuestStatus status, Id reserveId) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.reserveId = reserveId;
    }

    public boolean isSameGuest(Id userId) {
        return this.userId.equals(userId);
    }

    public Guest updateGuest(Id userId, Name newName, CPF newCpf, GuestStatus status, Id newReserveId) {
        return new Guest(newName, newCpf, status, newReserveId);
    }

    public void updateStatus(boolean newStatus) {
        status.updateStatus(newStatus);
    }

    public boolean isHosted() {
        return status.isHosted();
    }
    
}