package br.edu.ifpb.interfaces.usecase;

import br.edu.ifpb.domain.wrappers.*;

public interface UpdateRoomUseCaseIF {
    public void updateRoom(Id roomId, RoomNumber newNumber, Id newRoomType, RoomStatus newStatus);
}
