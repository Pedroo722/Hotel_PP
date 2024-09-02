package br.edu.ifpb.interfaces.usecase;

import br.edu.ifpb.domain.wrappers.*;

public interface UpdateReserveUseCaseIF {
    public void updateReserve(Id reserveId, Id newGuest, RoomNumber newNumber);
}
