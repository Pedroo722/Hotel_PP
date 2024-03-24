package br.edu.ifpb.model;

import java.time.LocalDate;

import br.edu.ifpb.wrappers.*;

public class Reserve {
    private Id reserveId;
    private Id userId;
    private RoomNumber number;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReserveStatus status;

    public Reserve(Id userId, RoomNumber number, LocalDate checkIn, LocalDate checkOut) {
        this.reserveId = new Id();
        this.userId = userId;
        this.number = number;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean isSameReserve(Id reserveId) {
        return this.reserveId.equals(reserveId);
    }

    public void checkIn(LocalDate checkInDate) {

    }

    public void checkOut(LocalDate checkOutDate) {
        
    }

    public void updateReserve(Id reserveId, Boolean newStatus) {

    }

    public void cancelReserve(Id reserveId) {

    }
}