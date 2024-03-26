package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.model.Room;

public class CheckRoomIdentityUseCase {
    public static boolean isSameRoom(Room room, Id roomId) {
        return room.getRoomId().equals(roomId);
    }
}