package br.edu.ifpb.domain.model;

import java.io.Serializable;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

public class Room implements Serializable {
    private Id roomId;
    private RoomNumber number;
    private RoomType roomType;
    private RoomStatus status;

    private Room(RoomBuilder builder) {
        this.roomId = builder.roomId;
        this.number = builder.number;
        this.roomType = builder.roomType;
        this.status = builder.status;
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

    public static class RoomBuilder {
        private Id roomId;
        private RoomNumber number;
        private RoomType roomType;
        private RoomStatus status;

        public RoomBuilder() {
            this.roomId = new Id();
            this.status = RoomStatus.AVAILABLE; 
        }

        public RoomBuilder withNumber(RoomNumber number) {
            this.number = number;
            return this;
        }

        public RoomBuilder withRoomType(RoomType roomType) {
            this.roomType = roomType;
            return this;
        }

        public RoomBuilder withStatus(RoomStatus status) {
            this.status = status;
            return this;
        }

        public Room build() {
            if (this.number == null || this.roomType == null) {
                throw new IllegalRoomException();
            }
            return new Room(this);
        }
    }
}
