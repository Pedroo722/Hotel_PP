package br.edu.ifpb.domain.cases.ReserveUseCase;

import java.time.LocalDate;

import br.edu.ifpb.data.ReserveRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.repository.ReserveRepositoryInterface;

public class ReserveCheckInUseCase {
    private ReserveRepositoryInterface repository;
    
    public ReserveCheckInUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

    public ReserveCheckInUseCase(ReserveRepositoryInterface repository) {
        this.repository = repository;
    }

    public void checkIn(Id reserveId, LocalDate checkInDate) {
        Reserve reserve = repository.findReserveById(reserveId);

        if (checkInDate == null || checkInDate.isBefore(LocalDate.now())) {
            return;
        }

        reserve.setCheckIn(checkInDate);
        reserve.setStatus(ReserveStatus.ACTIVE);
        repository.updateReserve(reserve);
    }
}
