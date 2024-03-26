package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;

public class Room {
    private Id roomId;
    private RoomNumber number;
    private Id roomTypeId;
    private RoomStatus status; // status do quarto | true = livre e false = sujo/ocupado
    // trocar classe wrapper de status para enum

    public Room(RoomNumber number, Id roomTypeId, RoomStatus status) {
        this.roomId = new Id();
        this.number = number;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }

    public Id getRoomId() { return roomId; }
    public RoomNumber getNumber() { return number; }
    public Id getRoomTypeId() { return roomTypeId; }
    public RoomStatus getStatus() { return status; }

    public void setRoomId(Id roomId) { this.roomId = roomId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setRoomTypeId(Id roomTypeId) { this.roomTypeId = roomTypeId; }
    public void setStatus(RoomStatus status) { this.status = status; }
}