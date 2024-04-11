package br.edu.ifpb.domain.model;

import java.io.Serializable;

import br.edu.ifpb.domain.wrappers.*;

public class Room implements Serializable {
    private Id roomId;
    private RoomNumber number;
    private RoomType roomType;
    private RoomStatus status;

    public Room(RoomNumber number, RoomType roomType, RoomStatus status) {
        this.roomId = new Id();
        this.number = number;
        this.roomType = roomType;
        this.status = status;
    }

    public Id getRoomId() { return roomId; }
    public RoomNumber getNumber() { return number; }
    public RoomType getRoomTypeId() { return roomType; }
    public RoomStatus getStatus() { return status; }

    public void setRoomId(Id roomId) { this.roomId = roomId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setRoomTypeId(RoomType roomType) { this.roomType = roomType; }
    public void setStatus(RoomStatus status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* ID: ").append(roomId).append("\n");
        sb.append("* Number: ").append(number).append("\n");
        sb.append(roomType.toString());
        sb.append("* RoomStatus: ").append(status).append("\n");
        return sb.toString();
    }
}