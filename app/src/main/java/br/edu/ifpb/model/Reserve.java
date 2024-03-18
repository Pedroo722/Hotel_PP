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

    
    public boolean isSameReserve(Id reserveId) {
        return this.reserveId.equals(reserveId);
    }

    public Reserve(Id bookingId, Id userId, RoomNumber number, LocalDate checkIn, LocalDate checkOut) {
        this.reserveId = new Id();
        this.userId = userId;
        this.number = number;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void checkIn(LocalDate checkInDate) {
        checkIn = checkInDate;
    }

    public void checkOut(LocalDate checkOutDate) {
        checkOut = checkOutDate;
    }

    public void updateReserve(Id reserveId) {

    }

    public void cancelReserve(Id reserveId) {

    }
}
