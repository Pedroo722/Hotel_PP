package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateReserveUseCaseIf;

public class UpdateReserveUseCase implements UpdateReserveUseCaseIf {
    public void updateReserve(Reserve reserve, Id newGuest, RoomNumber newNumber, ReserveStatus newStatus) {
        reserve.setUserId(newGuest);
        reserve.setNumber(newNumber);
        reserve.setStatus(newStatus);
    }
}
