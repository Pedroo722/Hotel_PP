package br.edu.ifpb.domain.cases.ReserveUseCase;

import br.edu.ifpb.data.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.repository.*;
import br.edu.ifpb.interfaces.usecase.*;

public class RemoveReserveUseCase implements RemoveReserveUseCaseIF {
    private ReserveRepositoryInterface repository;

    public RemoveReserveUseCase() {
        this.repository = ReserveRepository.getInstance();
    }

    public void removeReserve(Id reserveId) {
        repository.removeReserve(reserveId);
    }
}
