package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.domain.wrappers.*;

public interface UpdateReserveUseCaseIf {
    public void updateReserve(Reserve reserve, Id newGuest, RoomNumber newNumber, ReserveStatus newStatus);
}
