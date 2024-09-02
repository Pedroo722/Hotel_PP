package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.repository.*;
import br.edu.ifpb.interfaces.usecase.RemoveGuestUseCaseIF;

public class RemoveGuestUseCase implements RemoveGuestUseCaseIF {
    private GuestRepositoryInterface repository;

    public RemoveGuestUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public void removeGuest(Id userId) {
        repository.removeGuest(userId);
    }
}