package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;

public class RemoveGuestUseCase {
    private GuestRepositoryInterface repository;

    public void removeGuest(GuestRepositoryInterface repository, Guest guest) {
        guest = null;
    }
}
