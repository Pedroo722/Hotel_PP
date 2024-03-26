package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.RoomStatus;
import br.edu.ifpb.interfaces.controller.CleanRoomUseCaseIF;

public class CleanRoomUseCase implements CleanRoomUseCaseIF {
    public void cleanRoom(Room room, RoomStatus statusClean) {
        room.setStatus(statusClean);
    }
}
