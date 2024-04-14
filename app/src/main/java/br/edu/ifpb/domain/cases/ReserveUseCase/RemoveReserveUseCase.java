package br.edu.ifpb.domain.cases.ReserveUseCase;


import br.edu.ifpb.domain.repository.*;
import br.edu.ifpb.data.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.interfaces.controller.*;

public class RemoveReserveUseCase implements RemoveReserveUseCaseIF {
    private ReserveRepositoryInterface repository;

    public RemoveReserveUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

    public void removeReserve(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);
        Id guestId = reserve.getUserId();
        RoomNumber roomNumber = reserve.getNumber();

        repository.removeReserve(reserveId);


        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase();
        updateGuestStatusUseCase.updateGuestStatus(guestId);

        UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase();
        updateRoomStatusUseCase.updateRoomStatus(roomNumber);
    }
}
