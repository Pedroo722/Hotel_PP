package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.GuestIF;
import br.edu.ifpb.wrappers.*;

public class Guest implements GuestIF {
    private final Id userId;
    private final Name name;
    private final CPF cpf;

    public Guest(Name name , CPF cpf) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
    }

    public Guest updateGuest(Name newName, CPF newCpf) {
        return new Guest(newName, newCpf);
    }

    public boolean isSameGuest(Id userId) {
        return this.userId.equals(userId);
    }
}


