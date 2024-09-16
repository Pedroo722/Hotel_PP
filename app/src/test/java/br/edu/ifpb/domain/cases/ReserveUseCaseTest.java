package br.edu.ifpb.domain.cases;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.domain.cases.ReserveUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.repository.ReserveRepositoryInterface;

public class ReserveUseCaseTest {
    private ReserveRepositoryInterface repositoryMock;
    private Reserve reserve;

    @BeforeEach
    public void setUp() {
        repositoryMock = new ReserveRepositoryInterface() {
            private final Map<Id, Reserve> reserveRepo = new HashMap<>();

            @Override
            public Reserve findReserveById(Id id) {
                return reserveRepo.get(id);
            }

            @Override
            public void addReserve(Reserve reserve) {
                reserveRepo.put(reserve.getReserveId(), reserve);
            }

            @Override
            public void updateReserve(Reserve reserve) {
                reserveRepo.put(reserve.getReserveId(), reserve);
            }

            @Override
            public void removeReserve(Id id) {
                reserveRepo.remove(id);
            }

            @Override
            public List<Reserve> getReserves() {
                return List.copyOf(reserveRepo.values());
            }
        };

        Id userId = new Id();
        RoomNumber roomNumber = new RoomNumber(101);
        Id serviceId = new Id();
        reserve = new Reserve(userId, roomNumber, serviceId);

        repositoryMock.addReserve(reserve);
    }
    
    @Test
    public void testCheckReserveIdentity() {
        Id testReserveId = reserve.getReserveId();
        assertTrue(CheckReserveIdentityUseCase.isSameReserve(reserve, testReserveId));
        assertFalse(CheckReserveIdentityUseCase.isSameReserve(reserve, new Id()));
    }

    @Test
    public void testRemoveReserve() {
        Id reserveId = reserve.getReserveId();
        repositoryMock.removeReserve(reserveId);

        assertNull(repositoryMock.findReserveById(reserveId));
    }

    @Test
    public void testReserveCheckinUseCase() {
        LocalDate checkInDate = LocalDate.now().plusDays(1);
        ReserveCheckInUseCase reserveCheckInUseCase = new ReserveCheckInUseCase(repositoryMock);
        reserveCheckInUseCase.checkIn(reserve.getReserveId(), checkInDate);

        Reserve checkedInReserve = repositoryMock.findReserveById(reserve.getReserveId());
        assertNotNull(checkedInReserve);
        assertEquals(checkInDate, checkedInReserve.getCheckIn());
        assertEquals(ReserveStatus.ACTIVE, checkedInReserve.getStatus());
    }

    @Test
    public void testReserveCheckoutUseCase() {
        ReserveCheckOutUseCase reserveCheckOutUseCase = new ReserveCheckOutUseCase(repositoryMock);
        reserveCheckOutUseCase.checkOut(reserve.getReserveId());

        Reserve checkedOutReserve = repositoryMock.findReserveById(reserve.getReserveId());
        assertNotNull(checkedOutReserve);
        assertNotNull(checkedOutReserve.getCheckOut());
    }

    @Test
    public void testUpdateReserveStatusToCanceled() {
        reserve.setStatus(ReserveStatus.ACTIVE);
        repositoryMock.updateReserve(reserve);

        UpdateReserveStatusUseCase updateReserveStatusUseCase = new UpdateReserveStatusUseCase(repositoryMock);
        updateReserveStatusUseCase.updateReserveStatus(reserve.getReserveId());

        assertEquals(ReserveStatus.FINALIZED, repositoryMock.findReserveById(reserve.getReserveId()).getStatus());
    }

    @Test
    public void testUpdateReserve() {
        Id newGuest = new Id();
        RoomNumber newRoomNumber = new RoomNumber(102);

        UpdateReserveUseCase updateReserveUseCase = new UpdateReserveUseCase(repositoryMock);
        updateReserveUseCase.updateReserve(reserve.getReserveId(), newGuest, newRoomNumber);

        Reserve updatedReserve = repositoryMock.findReserveById(reserve.getReserveId());
        assertNotNull(updatedReserve);
        assertEquals(newGuest, updatedReserve.getUserId());
        assertEquals(newRoomNumber, updatedReserve.getNumber());
    }
}
