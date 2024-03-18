package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.wrappers.Id;

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
            if (room.isSameRoom(roomId)) {
                return room;
            }
        }
        return null;
    }
}
