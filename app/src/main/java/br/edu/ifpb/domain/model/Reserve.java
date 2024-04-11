package br.edu.ifpb.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import br.edu.ifpb.domain.wrappers.*;

public class Reserve implements Serializable {
    private Id reserveId;
    private Id userId;
    private RoomNumber number;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReserveStatus status;
    // trocar classe wrapper de status para enum

    public Reserve(Id userId, RoomNumber number) {
        this.reserveId = new Id();
        this.userId = userId;
        this.number = number;
        this.checkIn = null;
        this.checkOut = null;
    }

    public Id getReserveId() { return reserveId; }
    public Id getUserId() { return userId; }
    public RoomNumber getNumber() { return number; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public ReserveStatus getStatus() { return status; }

    public void setReserveId(Id reserveId) { this.reserveId = reserveId; }
    public void setUserId(Id userId) { this.userId = userId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }
    public void setStatus(ReserveStatus status) { this.status = status; } 

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("* ID: ").append(reserveId).append("\n");
        stringBuilder.append("* Nome do Hóspede: ").append(userId).append("\n");
        stringBuilder.append("* Número de Quarto: ").append(number).append("\n");
        stringBuilder.append("* Check-in: ").append(checkIn).append("\n");
        stringBuilder.append("* Check-out: ").append(checkOut);
        return stringBuilder.toString();
    }
}   