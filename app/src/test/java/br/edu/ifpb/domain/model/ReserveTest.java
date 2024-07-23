package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTest {

    @Test
    public void testReserveCreation() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);

        assertNotNull(reserve.getReserveId());
        assertEquals(userId, reserve.getUserId());
        assertEquals(roomNumber, reserve.getNumber());
        assertNull(reserve.getCheckIn());
        assertNull(reserve.getCheckOut());
        assertEquals(ReserveStatus.ACTIVE, reserve.getStatus());
    }

    @Test
    public void testSetReserveId() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        Id newReserveId = new Id();
        reserve.setReserveId(newReserveId);
        
        assertEquals(newReserveId, reserve.getReserveId());
    }

    @Test
    public void testSetUserId() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        Id newUserId = new Id();
        reserve.setUserId(newUserId);
        
        assertEquals(newUserId, reserve.getUserId());
    }

    @Test
    public void testSetNumber() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        RoomNumber newRoomNumber = new RoomNumber(102);
        reserve.setNumber(newRoomNumber);
        
        assertEquals(newRoomNumber, reserve.getNumber());
    }

    @Test
    public void testSetCheckIn() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        LocalDate checkIn = LocalDate.of(2024, 7, 23);
        reserve.setCheckIn(checkIn);
        
        assertEquals(checkIn, reserve.getCheckIn());
    }

    @Test
    public void testSetCheckOut() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        LocalDate checkOut = LocalDate.of(2024, 7, 30);
        reserve.setCheckOut(checkOut);
        
        assertEquals(checkOut, reserve.getCheckOut());
    }

    @Test
    public void testSetStatus() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        reserve.setStatus(ReserveStatus.CANCELED);
        
        assertEquals(ReserveStatus.CANCELED, reserve.getStatus());
    }

    @Test
    public void testToString() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Reserve reserve = new Reserve(userId, roomNumber);
        
        LocalDate checkIn = LocalDate.of(2024, 7, 23);
        LocalDate checkOut = LocalDate.of(2024, 7, 30);
        reserve.setCheckIn(checkIn);
        reserve.setCheckOut(checkOut);
        
        String expected = "* ID: " + reserve.getReserveId() + "\n" +
                          "* ID do Hóspede: " + userId + "\n" +
                          "* Número de Quarto: " + roomNumber + "\n" +
                          "* Check-in: " + checkIn + "\n" +
                          "* Check-out: " + checkOut;
        
        assertEquals(expected, reserve.toString());
    }
}
