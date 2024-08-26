package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testRoomCreation() {
        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single"); 
        
        RoomNumber roomNumber = new RoomNumber(20);
        RoomStatus status = RoomStatus.AVAILABLE; 
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomTypeId(smallRoomType.getRoomTypeId()) 
            .withStatus(status)
            .build();
            
        assertNotNull(room.getRoomId());
        assertEquals(roomNumber, room.getNumber());
        assertEquals(smallRoomType.getRoomTypeId(), room.getRoomTypeId());
        assertEquals(RoomStatus.AVAILABLE, room.getStatus());
    }

    @Test
    public void testSetRoomId() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single");
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomTypeId(smallRoomType.getRoomTypeId())
            .withStatus(status)
            .build();

        Id newRoomId = new Id(); 
        room.setRoomId(newRoomId);

        assertEquals(newRoomId, room.getRoomId());
    }

    @Test
    public void testSetNumber() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single");
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomTypeId(smallRoomType.getRoomTypeId()) 
            .withStatus(status)
            .build();

        RoomNumber newRoomNumber = new RoomNumber(102);
        room.setNumber(newRoomNumber);

        assertEquals(newRoomNumber, room.getNumber());
    }

    @Test
    public void testSetStatus() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single");
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomTypeId(smallRoomType.getRoomTypeId())
            .withStatus(status)
            .build();

        RoomStatus newStatus = RoomStatus.OCCUPIED; 
        room.setStatus(newStatus);

        assertEquals(newStatus, room.getStatus());
    }

    @Test
    public void testToString() {
        RoomNumber roomNumber = new RoomNumber(20);
        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single");
        RoomStatus status = RoomStatus.AVAILABLE;
        Room room = new Room.RoomBuilder()
            .withNumber(roomNumber)
            .withRoomTypeId(smallRoomType.getRoomTypeId())
            .withStatus(status)
            .build();

        String expected = "* ID: " + room.getRoomId() + "\n" +
                          "* Number: " + roomNumber + "\n" +
                          "* RoomType ID: " + smallRoomType.getRoomTypeId() + "\n" + 
                          "* RoomStatus: " + status + "\n";

        assertEquals(expected, room.toString());
    }
}
