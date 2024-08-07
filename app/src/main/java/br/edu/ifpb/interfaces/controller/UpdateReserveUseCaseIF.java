package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.*;

public interface UpdateReserveUseCaseIF {
    public void updateReserve(Id reserveId, Id newGuest, RoomNumber newNumber);
}
