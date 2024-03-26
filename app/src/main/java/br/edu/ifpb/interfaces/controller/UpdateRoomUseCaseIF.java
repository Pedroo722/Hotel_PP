package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.domain.wrappers.RoomNumber;
import br.edu.ifpb.domain.wrappers.RoomStatus;

public interface UpdateRoomUseCaseIF {
    public void updateRoom(Room room, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus);
}
