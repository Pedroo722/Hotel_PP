package br.edu.ifpb.domain.model;

import java.io.Serializable;
import br.edu.ifpb.domain.wrappers.*;

public class Guest implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("* ID: ").append(userId).append("\n");
        stringBuilder.append("* Nome: ").append(name).append("\n");
        stringBuilder.append("* CPF: ").append(cpf).append("\n");
        stringBuilder.append("* Reserva: ").append(reserveId != null ? "[" + reserveId + "]" : "N/A").append("\n");
        stringBuilder.append("* Status: ").append(status);
        return stringBuilder.toString();
    }
}