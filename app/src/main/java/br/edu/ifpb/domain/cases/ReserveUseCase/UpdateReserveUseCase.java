package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.data.ReserveRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateReserveUseCaseIf;

public class UpdateReserveUseCase implements UpdateReserveUseCaseIf {
    private ReserveRepositoryInterface repository;

    public UpdateReserveUseCase() {
        this.repository = ReserveRepository.getInstance();
    }
    
    public void updateReserve(Id reserveId, Id newGuest, RoomNumber newNumber, ReserveStatus newStatus) {
        Reserve reserve = repository.findReserveById(reserveId);

        if(reserve == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        reserve.setUserId(newGuest);
        reserve.setNumber(newNumber);
        reserve.setStatus(newStatus);
    }
}
