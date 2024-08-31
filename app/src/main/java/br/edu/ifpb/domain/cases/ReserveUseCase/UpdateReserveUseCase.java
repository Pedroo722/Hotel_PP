package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.data.ReserveRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateReserveUseCaseIF;
import br.edu.ifpb.interfaces.repository.ReserveRepositoryInterface;

public class UpdateReserveUseCase implements UpdateReserveUseCaseIF {
    private ReserveRepositoryInterface repository;

    public UpdateReserveUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

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
