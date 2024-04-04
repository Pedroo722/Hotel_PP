package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.controller.RemoveReserveUseCaseIF;

public class RemoveReserveUseCase implements RemoveReserveUseCaseIF {
    private ReserveRepositoryInterface repository;

    public void removeReserve(Id reserveId) {
        Reserve reserve = repository.findReserveById(reserveId);

        if(reserve == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        reserve = null;
    }
}
