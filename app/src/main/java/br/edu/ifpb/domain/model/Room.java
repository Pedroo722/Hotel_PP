package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

public class Room {
    private Id roomId;
    private RoomNumber number;
    private Id roomTypeId;
    private RoomStatus status;
    
    private int numberOfBeds;
    private int numberOfTvs;
    private int numberOfBathrooms;
    private boolean suite;
    private boolean airConditioning;

    private Room(RoomBuilder builder) {
        this.roomId = builder.roomId;
        this.number = builder.number;
        this.roomTypeId = builder.roomTypeId;
        this.status = builder.status;
        this.numberOfBeds = builder.numberOfBeds;
        this.numberOfTvs = builder.numberOfTvs;
        this.numberOfBathrooms = builder.numberOfBathrooms;
        this.suite = builder.suite;
        this.airConditioning = builder.airConditioning;
    }

    public Room(Id roomId, RoomBuilder builder) {
        this.roomId = roomId;
        this.number = builder.number;
        this.roomTypeId = builder.roomTypeId;
        this.status = builder.status;
        this.numberOfBeds = builder.numberOfBeds;
        this.numberOfTvs = builder.numberOfTvs;
        this.numberOfBathrooms = builder.numberOfBathrooms;
        this.suite = builder.suite;
        this.airConditioning = builder.airConditioning;
    }

    public Id getRoomId() { return roomId; }
    public RoomNumber getNumber() { return number; }
    public Id getRoomTypeId() { return roomTypeId; } 
    public RoomStatus getStatus() { return status; }
    public int getNumberOfBeds() { return numberOfBeds; }
    public int getNumberOfTvs() { return numberOfTvs; }
    public int getNumberOfBathrooms() { return numberOfBathrooms; }
    public boolean isSuite() { return suite; }
    public boolean hasAirConditioning() { return airConditioning; }

    public void setRoomId(Id roomId) { this.roomId = roomId; }
    public void setNumber(RoomNumber number) { this.number = number; }
    public void setRoomTypeId(Id roomTypeId) { this.roomTypeId = roomTypeId; }
    public void setStatus(RoomStatus status) { this.status = status; }
    public void setNumberOfBeds(int numberOfBeds) { this.numberOfBeds = numberOfBeds; }
    public void setNumberOfTvs(int numberOfTvs) { this.numberOfTvs = numberOfTvs; }
    public void setNumberOfBathrooms(int numberOfBathrooms) { this.numberOfBathrooms = numberOfBathrooms; }
    public void setSuite(boolean suite) { this.suite = suite; }
    public void setAirConditioning(boolean airConditioning) { this.airConditioning = airConditioning; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* ID: ").append(roomId).append("\n");
        sb.append("* Number: ").append(number).append("\n");
        sb.append("* RoomType ID: ").append(roomTypeId).append("\n"); 
        sb.append("* RoomStatus: ").append(status).append("\n");
        sb.append("* Number of Beds: ").append(numberOfBeds).append("\n");
        sb.append("* Number of TVs: ").append(numberOfTvs).append("\n");
        sb.append("* Number of Bathrooms: ").append(numberOfBathrooms).append("\n");
        sb.append("* Suite: ").append(suite ? "Yes" : "No").append("\n");
        sb.append("* Air Conditioning: ").append(airConditioning ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    // Padrão de Criação: Builder
    public static class RoomBuilder {
        private Id roomId;
        private RoomNumber number;
        private Id roomTypeId; 
        private RoomStatus status;
        
        private int numberOfBeds;
        private int numberOfTvs;
        private int numberOfBathrooms;
        private boolean suite;
        private boolean airConditioning;

        public RoomBuilder() {
            this.roomId = new Id();
            this.status = RoomStatus.AVAILABLE; 
            this.numberOfBeds = 1;
            this.numberOfTvs = 1;
            this.numberOfBathrooms = 1;
            this.suite = false;
            this.airConditioning = false;
        }

        public RoomBuilder withNumber(RoomNumber number) {
            this.number = number;
            return this;
        }

        public RoomBuilder withRoomTypeId(Id roomTypeId) { 
            this.roomTypeId = roomTypeId;
            return this;
        }

        public RoomBuilder withStatus() {
            this.status = RoomStatus.AVAILABLE;
            return this;
        }

        public RoomBuilder withStatus(RoomStatus status) {
            this.status = status;
            return this;
        }

        public RoomBuilder withNumberOfBeds(int numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
            return this;
        }

        public RoomBuilder withNumberOfTvs(int numberOfTvs) {
            this.numberOfTvs = numberOfTvs;
            return this;
        }

        public RoomBuilder withNumberOfBathrooms(int numberOfBathrooms) {
            this.numberOfBathrooms = numberOfBathrooms;
            return this;
        }

        public RoomBuilder withSuite(boolean suite) {
            this.suite = suite;
            return this;
        }

        public RoomBuilder withAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public Room build() {
            if (this.number == null || this.roomTypeId == null) {
                throw new IllegalRoomException();
            }
            return new Room(this);
        }

        // Métodos para quartos específicos
        public static RoomBuilder smallRoom() {
            return new RoomBuilder()
                .withNumberOfBeds(1)
                .withNumberOfTvs(1)
                .withNumberOfBathrooms(1)
                .withAirConditioning(false)
                .withSuite(false);
        }

        public static RoomBuilder mediumRoom() {
            return new RoomBuilder()
                .withNumberOfBeds(2)
                .withNumberOfTvs(1)
                .withNumberOfBathrooms(1)
                .withAirConditioning(true)
                .withSuite(false);
        }

        public static RoomBuilder largeRoom() {
            return new RoomBuilder()
                .withNumberOfBeds(4)
                .withNumberOfTvs(2)
                .withNumberOfBathrooms(2)
                .withAirConditioning(true)
                .withSuite(false);
        }

        public static RoomBuilder deluxeRoom() {
            return new RoomBuilder()
                .withNumberOfBeds(1)
                .withNumberOfTvs(1)
                .withNumberOfBathrooms(1)
                .withAirConditioning(true)
                .withSuite(true);
        }
    }
}
