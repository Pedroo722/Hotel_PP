package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.GuestNotFoundException;
import br.edu.ifpb.interfaces.observer.GuestStatusObserver;
import br.edu.ifpb.interfaces.repository.GuestRepositoryInterface;

public class UpdateGuestStatusUseCase {
    private GuestRepositoryInterface repository;

    public UpdateGuestStatusUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public UpdateGuestStatusUseCase(GuestRepositoryInterface repository) {
        this.repository = repository;
    }

    public void updateGuestStatus(Id userId) {
        Guest guest = repository.findGuestById(userId);

        if (guest == null) {
            throw new GuestNotFoundException();
        }
        
        GuestStatusObserver observer = new GuestStatusObserver();
        guest.attach(observer);
        GuestStatus currentStatus = guest.getStatus();

        if (currentStatus == GuestStatus.HOSTED) {
            guest.setStatus(GuestStatus.NOT_HOSTED);
        } else {
            guest.setStatus(GuestStatus.HOSTED);
        }

        repository.updateGuest(guest);
    }
}