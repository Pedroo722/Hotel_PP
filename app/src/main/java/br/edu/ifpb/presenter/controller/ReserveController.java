package br.edu.ifpb.presenter.controller;

import java.util.List;

import br.edu.ifpb.data.*;
import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.cases.ReserveUseCase.*;
import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class ReserveController {
    private ReserveRepository repository;

    public ReserveController() {
        this.repository = ReserveRepository.getInstance();
    }

    public void addReserve(Id guestId, RoomNumber roomNumber) {
        Reserve newReserve = new Reserve(guestId, roomNumber);
        repository.addReserve(newReserve);

        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
        updateGuestStatusUseCase.updateGuestStatus(guestId);

        UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
        updateRoomStatusUseCase.updateRoomStatus(roomNumber);
    }

    public void listReserves() {
        List<Reserve> reserves = repository.getReserves();
        if (reserves.isEmpty()) {
            System.out.println("\nA lista de convidados está vazia!\n");
            return;
        }

        int count = 1;
        System.out.println("\n== Lista de Reservas ==");
        for (Reserve reserve : reserves) {
            System.out.println("Reserva: #" + count);
            System.out.println(reserve.toString());
            System.out.println();
            count++;
        }
    }

    public void editReserve(Id reserveId, Id newGuest, RoomNumber roomNumber) {
        UpdateReserveUseCase updateReserveUseCase = new UpdateReserveUseCase();
        updateReserveUseCase.updateReserve(reserveId, newGuest, roomNumber);
    }

    public void checkOut(Id reserveId) {
        ReserveCheckOutUseCase reserveCheckOutUseCase = new ReserveCheckOutUseCase();
        reserveCheckOutUseCase.checkOut(reserveId);
    }

    public void removeReserve(Id id) {    
        RemoveReserveUseCase removeReserveUseCase = new RemoveReserveUseCase();
        removeReserveUseCase.removeReserve(id);
    }    

    public void handleFinish() {
        // repository.saveReservesToFile();
    }
}