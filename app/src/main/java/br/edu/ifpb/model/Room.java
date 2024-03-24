package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.RoomIF;
import br.edu.ifpb.wrappers.*;

public class Room implements RoomIF {
    private Id roomId;
    private RoomNumber number;
    private Id roomTypeId;
    private RoomStatus status; // status do quarto | true = livre e false = sujo/ocupado

    public Room(RoomNumber number, Id roomTypeId, RoomStatus status) {
        this.roomId = new Id();;
        this.number = number;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }

    public boolean isSameRoom(Id roomId) {
        return this.roomId.equals(roomId);
    }

    public Room updateRoom(Id rooomID, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus) {
        return new Room(newNumber, newRoomTypeId, newStatus);
    }

    public void removeRoom(Room room) {
        if (room.isSameRoom(roomId)) {
            room = null;
        }
    }
    
    public void cleanRoom(Id rooomID) {
       this.status.updateStatus(true);
    }
}