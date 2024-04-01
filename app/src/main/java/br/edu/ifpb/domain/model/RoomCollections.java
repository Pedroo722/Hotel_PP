package br.edu.ifpb.domain.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.RoomUseCase.CheckRoomIdentityUseCase;
import br.edu.ifpb.domain.wrappers.Id;

public class RoomCollections {
    private List<Room> roomList;

    public RoomCollections() {
        this.roomList = new ArrayList<>();
    }

    public List<Room> consultReserves() {
        return roomList;
    }

    public Room searchReserve(Id roomId) {
        for (Room room : roomList) {
            if (CheckRoomIdentityUseCase.isSameRoom(room, roomId)) {
                return room;
            }
        }
        return null;
    }
}