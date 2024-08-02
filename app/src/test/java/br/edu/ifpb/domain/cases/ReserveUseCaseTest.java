package br.edu.ifpb.domain.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.domain.cases.ReserveUseCase.CheckReserveIdentityUseCase;
import br.edu.ifpb.domain.cases.ReserveUseCase.UpdateReserveStatusUseCase;
import br.edu.ifpb.domain.cases.ReserveUseCase.UpdateReserveUseCase;
import br.edu.ifpb.domain.model.Reserve;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.domain.wrappers.ReserveStatus;
import br.edu.ifpb.domain.wrappers.RoomNumber;

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
        ReserveStatus status = ReserveStatus.ACTIVE;
        reserve = new Reserve(userId, roomNumber);

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
    public void testUpdateReserveStatusToCanceled() {
        reserve.setStatus(ReserveStatus.ACTIVE);
        repositoryMock.updateReserve(reserve);

        UpdateReserveStatusUseCase updateReserveStatusUseCase = new UpdateReserveStatusUseCase(repositoryMock);
        updateReserveStatusUseCase.updateReserveStatus(reserve.getReserveId());

        assertEquals(ReserveStatus.CANCELED, repositoryMock.findReserveById(reserve.getReserveId()).getStatus());
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