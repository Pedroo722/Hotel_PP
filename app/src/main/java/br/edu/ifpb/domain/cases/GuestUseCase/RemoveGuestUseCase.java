package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.controller.RemoveGuestUseCaseIF;

public class RemoveGuestUseCase implements RemoveGuestUseCaseIF {
    private GuestRepository repository;

    public RemoveGuestUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public void removeGuest(Id userId) {
        repository.removeGuest(userId);
    }
}