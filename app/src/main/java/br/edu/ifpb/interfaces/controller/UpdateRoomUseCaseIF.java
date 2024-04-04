package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.domain.wrappers.RoomNumber;
import br.edu.ifpb.domain.wrappers.RoomStatus;

public interface UpdateRoomUseCaseIF {
    public void updateRoom(Id roomId, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus);
}
