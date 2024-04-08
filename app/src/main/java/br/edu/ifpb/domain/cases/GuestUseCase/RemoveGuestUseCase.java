package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.controller.RemoveGuestUseCaseIF;

public class RemoveGuestUseCase implements RemoveGuestUseCaseIF {
    private GuestRepositoryInterface repository;

    public RemoveGuestUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public void removeGuest(Id userId) {
        Guest guest = repository.findGuestById(userId);

        if(guest == null) {
            // System.out.println("Guest não encontrado!");
            return;
        }

        repository.loadGuestsFromFile().remove(guest);
        // System.out.println("Guest removido com sucesso!");
    }
}
