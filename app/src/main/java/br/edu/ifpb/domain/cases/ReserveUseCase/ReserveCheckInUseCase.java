package br.edu.ifpb.domain.cases.ReserveUseCase;

import java.time.LocalDate;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.ReserveStatus;

public class ReserveCheckInUseCase {
    private ReserveRepositoryInterface repository;
    
    public void checkIn(Id reserveId, LocalDate checkInDate) {
        Reserve reserve = repository.findReserveById(reserveId);

        if(reserve == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        if (checkInDate == null || checkInDate.isBefore(LocalDate.now())) {
            return;
        }
        reserve.setCheckIn(checkInDate);
        reserve.setStatus(new ReserveStatus(true));
    }
}
