package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.GuestNotFoundException;
import br.edu.ifpb.interfaces.repository.GuestRepositoryInterface;

public class GuestSetReserveUseCase {
    private GuestRepositoryInterface repository;

    public GuestSetReserveUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public GuestSetReserveUseCase(GuestRepositoryInterface repository) {
        this.repository = repository;
    }

    public void setReserve(Id userId, Id reserveId) {
        Guest guest = repository.findGuestById(userId);
        if (guest == null) {
            throw new GuestNotFoundException();
        }
        guest.setReserveId(reserveId);
        repository.updateGuest(guest);
    }
}
