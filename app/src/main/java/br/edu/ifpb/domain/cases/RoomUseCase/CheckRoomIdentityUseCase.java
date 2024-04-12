package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.model.Room;

public class CheckRoomIdentityUseCase {
    public static boolean isSameRoom(Room room, RoomNumber roomNumber) {
        return room.getNumber().equals(roomNumber);
    }
}