package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.repository.GuestRepositoryInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GuestUseCaseTest {
    private GuestRepositoryInterface repositoryMock;
    private Guest guest;

    @BeforeEach
    public void setUp() {
        repositoryMock = new GuestRepositoryInterface() {
            private final Map<Id, Guest> guestRepo = new HashMap<>();

            @Override
            public Guest findGuestById(Id id) {
                return guestRepo.get(id);
            }

            @Override
            public void addGuest(Guest guest) {
                guestRepo.put(guest.getUserId(), guest);
            }

            @Override
            public void updateGuest(Guest guest) {
                guestRepo.put(guest.getUserId(), guest);
            }

            @Override
            public void removeGuest(Id id) {
                guestRepo.remove(id);
            }

            @Override
            public List<Guest> getGuests() {
                return List.copyOf(guestRepo.values());
            }
        };

        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        guest = new Guest(name, cpf);

        repositoryMock.addGuest(guest); // Simulate adding guest to repository
    }

    @Test
    public void testCheckGuestIdentity() {
        Id testUserId = guest.getUserId();
        assertTrue(CheckGuestIdentityUseCase.isSameGuest(guest, testUserId));
        assertFalse(CheckGuestIdentityUseCase.isSameGuest(guest, new Id()));
    }

    @Test
    public void testRemoveGuest() {
        Id guestId = guest.getUserId();
        repositoryMock.removeGuest(guestId);

        assertNull(repositoryMock.findGuestById(guestId));
    }

    @Test
    public void testUpdateGuestStatusToHosted() {
        guest.setStatus(GuestStatus.NOT_HOSTED);
        repositoryMock.updateGuest(guest);

        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase(repositoryMock);
        updateGuestStatusUseCase.updateGuestStatus(guest.getUserId());

        assertEquals(GuestStatus.HOSTED, repositoryMock.findGuestById(guest.getUserId()).getStatus());
    }

    @Test
    public void testUpdateGuestStatusToNotHosted() {
        guest.setStatus(GuestStatus.HOSTED);
        repositoryMock.updateGuest(guest);

        UpdateGuestStatusUseCase updateGuestStatusUseCase = new UpdateGuestStatusUseCase(repositoryMock);
        updateGuestStatusUseCase.updateGuestStatus(guest.getUserId());

        assertEquals(GuestStatus.NOT_HOSTED, repositoryMock.findGuestById(guest.getUserId()).getStatus());
    }

    @Test
    public void testUpdateGuest() {
        Name newName = new Name("Jane Doe");
        CPF newCpf = new CPF("987.654.321-00");

        UpdateGuestUseCase updateGuestUseCase = new UpdateGuestUseCase(repositoryMock);
        updateGuestUseCase.updateGuest(guest.getUserId(), newName, newCpf);

        Guest updatedGuest = repositoryMock.findGuestById(guest.getUserId());
        assertNotNull(updatedGuest);
        assertEquals(newName, updatedGuest.getName());
        assertEquals(newCpf, updatedGuest.getCpf());
    }

    @Test
    public void testSetGuestReserve() {
        Id reserveId = new Id();
        GuestSetReserveUseCase guestSetReserveUseCase = new GuestSetReserveUseCase(repositoryMock);
        guestSetReserveUseCase.setReserve(guest.getUserId(), reserveId);

        Guest updatedGuest = repositoryMock.findGuestById(guest.getUserId());
        assertNotNull(updatedGuest);
        assertEquals(reserveId, updatedGuest.getReserveId());
    }
}
