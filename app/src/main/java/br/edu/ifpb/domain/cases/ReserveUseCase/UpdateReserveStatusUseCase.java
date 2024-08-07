package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.data.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.*;
import br.edu.ifpb.domain.wrappers.*;

public class UpdateReserveStatusUseCase {
    private ReserveRepositoryInterface repository;

    public UpdateReserveStatusUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

    public UpdateReserveStatusUseCase(ReserveRepositoryInterface repository) {
        this.repository = repository;
    }

    public void updateReserveStatus(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);
        ReserveStatus currentStatus = reserve.getStatus();

        if (currentStatus == ReserveStatus.ACTIVE) {
            reserve.setStatus(ReserveStatus.CANCELED);
        } else {
            reserve.setStatus(ReserveStatus.ACTIVE);
        }
        
        repository.updateReserve(reserve);
    }
}
