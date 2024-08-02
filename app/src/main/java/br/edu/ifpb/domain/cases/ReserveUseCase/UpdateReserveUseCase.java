package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.data.ReserveRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateReserveUseCaseIf;

public class UpdateReserveUseCase implements UpdateReserveUseCaseIf {
    private ReserveRepositoryInterface repository;

    public UpdateReserveUseCase(ReserveRepositoryInterface repository) {
        this.repository = repository;
    }

    public void updateReserve(Id reserveId, Id newGuest, RoomNumber newNumber) {
        Reserve reserve = repository.findReserveById(reserveId);

        if (reserve != null) {
            reserve.setUserId(newGuest);
            reserve.setNumber(newNumber);
            repository.updateReserve(reserve);
        }
    }
}
