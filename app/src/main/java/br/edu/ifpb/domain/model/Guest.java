package br.edu.ifpb.domain.model;

import br.edu.ifpb.interfaces.observer.*;
import br.edu.ifpb.domain.wrappers.*;
import java.util.ArrayList;
import java.util.List;

public class Guest implements Observable<Guest> {
    private Id userId;
    private Name name;
    private CPF cpf;
    private Id reserveId;
    private GuestStatus status;
    private List<Observer<Guest>> observers;

    public Guest(Name name, CPF cpf) {
        this.userId = new Id();
        this.name = name;
        this.cpf = cpf;
        this.status = GuestStatus.NOT_HOSTED;
        this.reserveId = null;
        this.observers = new ArrayList<>();
    }

    public Guest(Name name, CPF cpf, Id reserveId, GuestStatus status) {
        this.userId = new Id();
        this.name = name;
        this.reserveId = reserveId;
        this.cpf = cpf;
        this.status = status;
        this.observers = new ArrayList<>();
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

    public void setStatus(GuestStatus status) {
        this.status = status;
        notifyObservers();  
    }

    public void attach(Observer<Guest> observer) {
        observers.add(observer);
    }

    public void detach(Observer<Guest> observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer<Guest> observer : observers) {
            observer.update(this);
        }
    }

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
