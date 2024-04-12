package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class CheckRoomStatusUseCase {
    public static boolean isRoomAvailable(Room room) {
        return room.getStatus() == RoomStatus.AVAILABLE;
    }
}
