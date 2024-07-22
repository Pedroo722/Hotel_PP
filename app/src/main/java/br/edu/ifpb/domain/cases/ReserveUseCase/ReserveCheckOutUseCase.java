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

    public void checkOut(Id reserveId, LocalDate checkOutDate) {
        Reserve reserve = repository.findReserveById(reserveId);

        if (checkOutDate == null || checkOutDate.isBefore(reserve.getCheckIn())) {
            return;
        }  

        // fazer o metodogetTime() para receber horario atual
        // então salvar a data

        reserve.setCheckOut(checkOutDate);
        repository.updateReserve(reserve);
    }    
}
