package br.edu.ifpb.domain.cases.ReserveUseCase;

import java.time.LocalDate;

import br.edu.ifpb.data.ReserveRepository;
import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;

public class ReserveCheckOutUseCase {
    private ReserveRepositoryInterface repository;

    public ReserveCheckOutUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

    public void checkOut(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);
        LocalDate checkOutDate = LocalDate.now();

        reserve.setCheckOut(checkOutDate);
        repository.updateReserve(reserve);
    }    
}
