package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.interfaces.controller.RemoveReserveUseCaseIF;

public class RemoveReserveUseCase implements RemoveReserveUseCaseIF {
    public void removeReserve(Reserve reserve) {
        reserve = null;
    }
}
