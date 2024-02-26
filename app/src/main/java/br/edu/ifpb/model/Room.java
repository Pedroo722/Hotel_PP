package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.RoomIF;

public class Room implements RoomIF {
    int roomId, roomNumber;
    String roomType, roomStatus;

    public Room(int roomId, int roomNumber, String roomType, String roomStatus) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public Room returnRoom(int roomId) {
        if (this.roomId == roomId) {
            return this;
        } 
        
        return null;
    }
}
