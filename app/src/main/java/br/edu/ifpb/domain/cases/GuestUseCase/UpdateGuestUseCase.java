package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.GuestNotFoundException;

public class UpdateGuestUseCase {
    private GuestRepositoryInterface repository;

    public UpdateGuestUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public UpdateGuestUseCase(GuestRepositoryInterface repository) {
        this.repository = repository;
    }

    public void updateGuest(Id userId, Name newName, CPF newCpf) {
        Guest guest = repository.findGuestById(userId);
        if (guest == null) {
            throw new GuestNotFoundException();
        }
        guest.setName(newName);
        guest.setCpf(newCpf);
        repository.updateGuest(guest);
    }
}
