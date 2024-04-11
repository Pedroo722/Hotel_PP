package br.edu.ifpb.domain.cases.RoomTypeUseCase;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.model.*;

public class CheckRoomTypeIdentityUseCase {
    public static boolean isSameRoomType(RoomType roomType, Id roomTypeId) {
        return roomType.getRoomTypeId().equals(roomTypeId);
    }
}