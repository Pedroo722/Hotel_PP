package br.edu.ifpb.domain.model;

import java.time.LocalDate;

import br.edu.ifpb.domain.wrappers.*;

public class Reserve {
    private Id reserveId;
    private Id userId;
    private RoomNumber number;
    private Id serviceId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReserveStatus status;

    public Reserve(Id userId, RoomNumber number, Id serviceId) {
        this.reserveId = new Id();
        this.userId = userId;
        this.number = number;
        this.serviceId = serviceId;
        this.checkIn = LocalDate.now();
        this.checkOut = null;
        this.status = ReserveStatus.ACTIVE;
    }

    public Reserve(Id reserveId, Id userId, RoomNumber number, Id serviceId, LocalDate checkIn, LocalDate checkOut, ReserveStatus status) {
        this.reserveId = reserveId;
        this.userId = userId;
        this.number = number;
        this.serviceId = serviceId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public Id getReserveId() { return reserveId; }
    public Id getUserId() { return userId; }
    public RoomNumber getNumber() { return number; }
    public Id getServiceId() { return serviceId; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public ReserveStatus getStatus() { return status; }

    public void setReserveId(Id reserveId) { this.reserveId = reserveId; }
    public void setUserId(Id userId) { this.userId = userId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setServiceId(Id serviceId) { this.serviceId = serviceId; } 
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }
    public void setStatus(ReserveStatus status) { this.status = status; } 

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("* ID: ").append(reserveId).append("\n");
        stringBuilder.append("* ID do Hóspede: ").append(userId).append("\n");
        stringBuilder.append("* Número de Quarto: ").append(number).append("\n");
        stringBuilder.append("* Service ID: ").append(serviceId).append("\n");
        stringBuilder.append("* Check-in: ").append(checkIn).append("\n");
        stringBuilder.append("* Check-out: ").append(checkOut).append('\n');
        stringBuilder.append("* Status: ").append(status);
        return stringBuilder.toString();
    }
}   