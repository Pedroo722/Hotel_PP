package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.RoomIF;
import br.edu.ifpb.wrappers.*;

public class Room implements RoomIF {
    private Id roomId;
    private RoomNumber number;
    private RoomType type;
    private RoomStatus status;

    public Room(Id roomId, RoomNumber number, RoomType type, RoomStatus status) {
        this.roomId = new Id();;
        this.number = number;
        this.type = type;
        this.status = status;
    }

    public boolean isSameRoom(Id roomId) {
        return this.roomId.equals(roomId);
    }

    public void registerRoom() {

    }

    public void updateRoom() {
    
    }

    public void removeRoom() {
       
    }

    public void cleanRoom() {
       
    }
}
