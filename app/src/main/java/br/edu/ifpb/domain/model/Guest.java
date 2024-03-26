package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;

public class Guest {
    private final Id userId;
    private Name name;
    private CPF cpf;
    private Id reserveId;
    private GuestStatus status; // true = hospedado no hotel
    // trocar classe wrapper de status para enum

    public Guest(Name name, CPF cpf, GuestStatus status, Id reserveId) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.reserveId = reserveId;
    }

    public Id getUserId() { return userId; }
    public Name getName() { return name; }
    public CPF getCpf() { return cpf; }
    public boolean isHosted() { return status.isHosted(); }
    public Id getReserveId() { return reserveId; }

    public void setName(Name name) { this.name = name; }
    public void setCpf(CPF cpf) { this.cpf = cpf; }
    public void setStatus(GuestStatus status) { this.status = status; }
    public void setReserveId(Id reserveId) { this.reserveId = reserveId; }
}