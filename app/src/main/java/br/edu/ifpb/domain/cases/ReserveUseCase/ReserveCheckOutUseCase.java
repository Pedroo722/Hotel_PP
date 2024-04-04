package br.edu.ifpb.domain.cases.ReserveUseCase;

import java.time.LocalDate;

import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;

public class ReserveCheckOutUseCase {
    private ReserveRepositoryInterface repository;

    public void checkOut(Id reserveId, LocalDate checkOutDate) {
        Reserve reserve = repository.findReserveById(reserveId);

        if(reserve == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        if (checkOutDate == null || checkOutDate.isBefore(reserve.getCheckIn())) {
            return;
        }        
        reserve.setCheckOut(checkOutDate);
    }    
}
