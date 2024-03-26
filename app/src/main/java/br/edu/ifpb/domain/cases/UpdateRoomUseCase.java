package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateRoomUseCaseIF;

public class UpdateRoomUseCase implements UpdateRoomUseCaseIF {
    public void updateRoom(Room room, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus) {
        room.setNumber(newNumber);
        room.setRoomTypeId(newRoomTypeId);
        room.setStatus(newStatus);
    }
}
