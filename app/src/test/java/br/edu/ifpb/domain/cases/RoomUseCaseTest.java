package br.edu.ifpb.domain.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.domain.cases.RoomUseCase.CheckRoomIdentityUseCase;
import br.edu.ifpb.domain.cases.RoomUseCase.CheckRoomStatusUseCase;
import br.edu.ifpb.domain.cases.RoomUseCase.UpdateRoomStatusUseCase;
import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.RoomNumber;
import br.edu.ifpb.domain.wrappers.RoomStatus;

public class RoomUseCaseTest {
    private RoomRepositoryInterface repositoryMock;
    private Room room;

    @BeforeEach
    public void setUp() {
        repositoryMock = new RoomRepositoryInterface() {
            private final Map<RoomNumber, Room> roomRepo = new HashMap<>();

            @Override
            public Room findRoomByNumber(RoomNumber roomNumber) {
                return roomRepo.get(roomNumber);
            }

            @Override
            public void addRoom(Room room) {
                roomRepo.put(room.getNumber(), room);
            }

            @Override
            public void updateRoom(Room room) {
                roomRepo.put(room.getNumber(), room);
            }

            @Override
            public List<Room> getRooms() {
                return List.copyOf(roomRepo.values());
            }
        };

        RoomNumber roomNumber = new RoomNumber(101);
        room = new Room(roomNumber, null, RoomStatus.AVAILABLE);

        repositoryMock.addRoom(room);
    }

    @Test
    public void testCheckRoomIdentity() {
        RoomNumber testRoomNumber = room.getNumber();
        assertTrue(CheckRoomIdentityUseCase.isSameRoom(room, testRoomNumber));
        assertFalse(CheckRoomIdentityUseCase.isSameRoom(room, new RoomNumber(102)));
    }

    @Test
    public void testCheckRoomStatus() {
        room.setStatus(RoomStatus.AVAILABLE);
        assertTrue(CheckRoomStatusUseCase.isRoomAvailable(room));

        room.setStatus(RoomStatus.OCCUPIED);
        assertFalse(CheckRoomStatusUseCase.isRoomAvailable(room));
    }

    @Test
    public void testUpdateRoomStatus() {
        room.setStatus(RoomStatus.AVAILABLE);
        repositoryMock.updateRoom(room);

        UpdateRoomStatusUseCase updateRoomStatusUseCase = new UpdateRoomStatusUseCase(repositoryMock);

        // Disponível -> Ocupado
        updateRoomStatusUseCase.updateRoomStatus(room.getNumber());
        assertEquals(RoomStatus.OCCUPIED, repositoryMock.findRoomByNumber(room.getNumber()).getStatus());

        // Ocupado -> Disponível
        updateRoomStatusUseCase.updateRoomStatus(room.getNumber());
        assertEquals(RoomStatus.AVAILABLE, repositoryMock.findRoomByNumber(room.getNumber()).getStatus());
    }
}
