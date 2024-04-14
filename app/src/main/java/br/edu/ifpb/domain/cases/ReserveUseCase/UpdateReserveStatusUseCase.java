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

    public void updateReserveStatus(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);
        ReserveStatus currentStatus = reserve.getStatus();
        
        if (currentStatus == ReserveStatus.ACTIVE) {
            String statusStr = "CANCELED";
            ReserveStatus canceledStatus = ReserveStatus.valueOf(statusStr);
            reserve.setStatus(canceledStatus);
            repository.updateReserve(reserve);
            return;
        }

        String statusStr = "CANCELED";
        ReserveStatus activeStatus = ReserveStatus.valueOf(statusStr);
        reserve.setStatus(activeStatus);
        repository.updateReserve(reserve);
    }   
}
