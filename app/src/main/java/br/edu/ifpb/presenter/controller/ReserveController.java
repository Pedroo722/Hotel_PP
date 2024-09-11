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
        try {
            Reserve newReserve = new Reserve(guestId, roomNumber);
            repository.addReserve(newReserve);

            UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
            updateGuestStatusUseCase.updateGuestStatus(guestId);

            UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
            updateRoomStatusUseCase.updateRoomStatus(roomNumber);

            GuestSetReserveUseCase guestSetReserveUseCase = new GuestSetReserveUseCase();
            guestSetReserveUseCase.setReserve(guestId, newReserve.getReserveId());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar a reserva: " + e.getMessage());
        }
    }

    public void listReserves() {
        try {
            List<Reserve> reserves = repository.getReserves();
            if (reserves.isEmpty()) {
                throw new NoReservesAvailableException("A lista de reservas está vazia.");
            }

            int count = 1;
            System.out.println("\n== Lista de Reservas ==");
            for (Reserve reserve : reserves) {
                System.out.println("Reserva: #" + count);
                System.out.println(reserve.toString());
                System.out.println();
                count++;
            }
        } catch (NoReservesAvailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao listar as reservas: " + e.getMessage());
        }
    }

    public List<Reserve> getListReserves() {
        return repository.getReserves();
    }

    public void editReserve(Id reserveId, Id newGuest, RoomNumber roomNumber) {
        try {
            UpdateReserveUseCase updateReserveUseCase = new UpdateReserveUseCase();
            updateReserveUseCase.updateReserve(reserveId, newGuest, roomNumber);
        } catch (Exception e) {
            System.out.println("Erro ao editar a reserva: " + e.getMessage());
        }
    }

    public void checkOut(Id reserveId) {
        try {
            ReserveCheckOutUseCase reserveCheckOutUseCase = new ReserveCheckOutUseCase();
            reserveCheckOutUseCase.checkOut(reserveId);

            UpdateReserveStatusUseCase updateReserveStatusUseCase = new UpdateReserveStatusUseCase();
            updateReserveStatusUseCase.updateReserveStatus(reserveId);
        } catch (Exception e) {
            System.out.println("Erro ao realizar o check-out: " + e.getMessage());
        }
    }

    public void removeReserve(Id id) {
        try {
            Reserve reserve = repository.findReserveById(id);
            if (reserve == null) {
                throw new ReserveNotFoundException("Reserva não encontrada.");
            }

            UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
            updateGuestStatusUseCase.updateGuestStatus(reserve.getUserId());

            UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
            updateRoomStatusUseCase.updateRoomStatus(reserve.getNumber());

            RemoveReserveUseCase removeReserveUseCase = new RemoveReserveUseCase();
            removeReserveUseCase.removeReserve(id);
        } catch (ReserveNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao remover a reserva: " + e.getMessage());
        }
    }

    public void handleFinish() {
        try {
            repository.saveReservesToDB();
        } catch (Exception e) {
            System.out.println("Erro ao salvar as reservas no banco de dados: " + e.getMessage());
        }
    }
}