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

    public void addReserve(Id guestId, RoomNumber roomNumber, Id serviceId) {
        Reserve newReserve = new Reserve(guestId, roomNumber, serviceId);
        repository.addReserve(newReserve);
        
        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
        updateGuestStatusUseCase.updateGuestStatus(guestId);

        UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
        updateRoomStatusUseCase.updateRoomStatus(roomNumber);

        GuestSetReserveUseCase guestSetReserveUseCase = new GuestSetReserveUseCase();
        guestSetReserveUseCase.setReserve(guestId, newReserve.getReserveId());
    }

    public void listReserves() {
        List<Reserve> reserves = repository.getReserves();
        if (reserves.isEmpty()) {
            System.out.println("\nA lista de reservas está vazia!\n");
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

    public List<Reserve> getListReserves() {
        return repository.getReserves();
    }

    public void editReserve(Id reserveId, Id newGuest, RoomNumber roomNumber) {
        UpdateReserveUseCase updateReserveUseCase = new UpdateReserveUseCase();
        updateReserveUseCase.updateReserve(reserveId, newGuest, roomNumber);
    }

    public void checkOut(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);

        ReserveCheckOutUseCase reserveCheckOutUseCase = new ReserveCheckOutUseCase();
        reserveCheckOutUseCase.checkOut(reserveId);

        UpdateReserveStatusUseCase updateReserveStatusUseCase = new UpdateReserveStatusUseCase();
        updateReserveStatusUseCase.updateReserveStatus(reserveId);

        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
        updateGuestStatusUseCase.updateGuestStatus(reserve.getUserId());
    }

    public void removeReserve(Id id) {            
        Reserve reserve = repository.findReserveById(id);

        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
        updateGuestStatusUseCase.updateGuestStatus(reserve.getUserId());
        
        UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
        updateRoomStatusUseCase.updateRoomStatus(reserve.getNumber());

        RemoveReserveUseCase removeReserveUseCase = new RemoveReserveUseCase();
        removeReserveUseCase.removeReserve(id);
    }    

    public Reserve getReserveById(Id reserveId) {
        return repository.findReserveById(reserveId);
    }

    public void handleFinish() {
        repository.saveReservesToDB();
    }
}