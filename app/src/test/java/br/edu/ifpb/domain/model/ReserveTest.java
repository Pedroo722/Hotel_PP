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
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 

        assertNotNull(reserve.getReserveId());
        assertEquals(userId, reserve.getUserId());
        assertEquals(roomNumber, reserve.getNumber());
        assertEquals(serviceId, reserve.getServiceId());
        assertEquals(reserve.getCheckIn(), reserve.getCheckIn());
        assertNull(reserve.getCheckOut());
        assertEquals(ReserveStatus.ACTIVE, reserve.getStatus());
    }

    @Test
    public void testSetReserveId() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        Id newReserveId = new Id();
        reserve.setReserveId(newReserveId);
        
        assertEquals(newReserveId, reserve.getReserveId());
    }

    @Test
    public void testSetUserId() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        Id newUserId = new Id();
        reserve.setUserId(newUserId);
        
        assertEquals(newUserId, reserve.getUserId());
    }

    @Test
    public void testSetNumber() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        RoomNumber newRoomNumber = new RoomNumber(102);
        reserve.setNumber(newRoomNumber);
        
        assertEquals(newRoomNumber, reserve.getNumber());
    }

    @Test
    public void testSetServiceId() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        Id newServiceId = new Id();
        reserve.setServiceId(newServiceId); // Verificando o setter
        
        assertEquals(newServiceId, reserve.getServiceId());
    }

    @Test
    public void testSetCheckIn() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        LocalDate checkIn = LocalDate.of(2024, 7, 23);
        reserve.setCheckIn(checkIn);
        
        assertEquals(checkIn, reserve.getCheckIn());
    }

    @Test
    public void testSetCheckOut() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        LocalDate checkOut = LocalDate.of(2024, 7, 30);
        reserve.setCheckOut(checkOut);
        
        assertEquals(checkOut, reserve.getCheckOut());
    }

    @Test
    public void testSetStatus() {
        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        Reserve reserve = new Reserve(userId, roomNumber, serviceId); 
        
        reserve.setStatus(ReserveStatus.CANCELED);
        
        assertEquals(ReserveStatus.CANCELED, reserve.getStatus());
    }
}
