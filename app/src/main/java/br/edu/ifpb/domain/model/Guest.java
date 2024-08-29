package br.edu.ifpb.domain.model;

import java.io.Serializable;
import br.edu.ifpb.domain.wrappers.*;

public class Guest implements Serializable {
    private Id userId;
    private Name name;
    private CPF cpf;
    private Id reserveId;
    private GuestStatus status;

    public Guest(Name name, CPF cpf) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = GuestStatus.NOT_HOSTED;
        this.reserveId = null;
    }

    public Guest(Id id, Name name, CPF cpf) {
        this.userId = id;
        this.name = name;
        this.cpf = cpf;
        this.status = GuestStatus.NOT_HOSTED;
        this.reserveId = null;
    }    

    public Guest(Name name, CPF cpf, GuestStatus status) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.reserveId = null;
    }  

    public Guest(Id id, Name name, CPF cpf, GuestStatus status) {
        this.userId = id;
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.reserveId = null;
    }   

    public Id getUserId() { return userId; }
    public Name getName() { return name; }
    public CPF getCpf() { return cpf; }
    public Id getReserveId() { return reserveId; }
    public GuestStatus getStatus() { return status; }

    public void setUserId(Id userId) { this.userId = userId; }
    public void setName(Name name) { this.name = name; }
    public void setCpf(CPF cpf) { this.cpf = cpf; }
    public void setReserveId(Id reserveId) { this.reserveId = reserveId; }
    public void setStatus(GuestStatus status) {this.status = status; }

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