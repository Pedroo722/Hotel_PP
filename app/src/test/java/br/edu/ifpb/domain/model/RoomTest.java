package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testRoomCreation() {
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1); 
        RoomType roomType = new RoomType(description, capacity);
        
        RoomNumber roomNumber = new RoomNumber(20);
        RoomStatus status = RoomStatus.AVAILABLE; 
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();
            

        assertNotNull(room.getRoomId());
        assertEquals(roomNumber, room.getNumber());
        assertEquals(roomType, room.getRoomTypeId());
        assertEquals(RoomStatus.AVAILABLE, room.getStatus());
    }

    @Test
    public void testSetRoomId() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1);
        RoomType roomType = new RoomType(description, capacity);
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();


        Id newRoomId = new Id(); 
        room.setRoomId(newRoomId);

        assertEquals(newRoomId, room.getRoomId());
    }

    @Test
    public void testSetNumber() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1);
        RoomType roomType = new RoomType(description, capacity);
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();


        RoomNumber newRoomNumber = new RoomNumber(102);
        room.setNumber(newRoomNumber);

        assertEquals(newRoomNumber, room.getNumber());
    }

    @Test
    public void testSetRoomType() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1);
        RoomType roomType = new RoomType(description, capacity);
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();


        RoomDescription newDescription = RoomDescription.LUXURY; 
        RoomCapacity newCapacity = new RoomCapacity(2); 
        RoomType newRoomType = new RoomType(newDescription, newCapacity);
        room.setRoomTypeId(newRoomType);

        assertEquals(newRoomType, room.getRoomTypeId());
    }

    @Test
    public void testSetStatus() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1);
        RoomType roomType = new RoomType(description, capacity);
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();


        RoomStatus newStatus = RoomStatus.OCCUPIED; 
        room.setStatus(newStatus);

        assertEquals(newStatus, room.getStatus());
    }

    @Test
    public void testToString() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomDescription description = RoomDescription.SMALL;
        RoomCapacity capacity = new RoomCapacity(1);
        RoomType roomType = new RoomType(description, capacity);
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomType(roomType)
            .withStatus(status)
            .build();


        String expected = "* ID: " + room.getRoomId() + "\n" +
                          "* Number: " + roomNumber + "\n" +
                          roomType.toString() +
                          "* RoomStatus: " + status + "\n";

        assertEquals(expected, room.toString());
    }
}
