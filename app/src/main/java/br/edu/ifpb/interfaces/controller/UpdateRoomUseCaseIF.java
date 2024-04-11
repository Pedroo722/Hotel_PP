package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.*;

public interface UpdateRoomUseCaseIF {
    public void updateRoom(Id roomId, RoomNumber newNumber, Id newRoomType, RoomStatus newStatus);
}
