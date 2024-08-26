package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

public class Room {
    private Id roomId;
    private RoomNumber number;
    private Id roomTypeId;
    private RoomStatus status;

    private Room(RoomBuilder builder) {
        this.roomId = builder.roomId;
        this.number = builder.number;
        this.roomTypeId = builder.roomTypeId;
        this.status = builder.status;
    }

    public Room(Id roomId, RoomBuilder builder) {
        this.roomId = roomId;
        this.number = builder.number;
        this.roomTypeId = builder.roomTypeId;
        this.status = builder.status;
    }

    public Id getRoomId() { return roomId; }
    public RoomNumber getNumber() { return number; }
    public Id getRoomTypeId() { return roomTypeId; } 
    public RoomStatus getStatus() { return status; }

    public void setRoomId(Id roomId) { this.roomId = roomId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setRoomTypeId(Id roomTypeId) { this.roomTypeId = roomTypeId; }
    public void setStatus(RoomStatus status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* ID: ").append(roomId).append("\n");
        sb.append("* Number: ").append(number).append("\n");
        sb.append("* RoomType ID: ").append(roomTypeId).append("\n"); 
        sb.append("* RoomStatus: ").append(status).append("\n");
        return sb.toString();
    }

    public static class RoomBuilder {
        private Id roomId;
        private RoomNumber number;
        private Id roomTypeId; // Store only the RoomType ID
        private RoomStatus status;

        public RoomBuilder() {
            this.roomId = new Id();
            this.status = RoomStatus.AVAILABLE; 
        }

        public RoomBuilder withNumber(RoomNumber number) {
            this.number = number;
            return this;
        }

        public RoomBuilder withRoomTypeId(Id roomTypeId) { 
            this.roomTypeId = roomTypeId;
            return this;
        }

        public RoomBuilder withStatus(RoomStatus status) {
            this.status = status;
            return this;
        }

        public Room build() {
            if (this.number == null || this.roomTypeId == null) {
                throw new IllegalRoomException();
            }
            return new Room(this);
        }
    }
}
