package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateGuestStatusUseCaseIF;

public class UpdateGuestStatusUseCase implements UpdateGuestStatusUseCaseIF {
    private GuestRepositoryInterface repository;

    public void updateStatus(Id userId, GuestStatus newStatus) {
        Guest guest = repository.findGuestById(userId);

        if(guest == null) {
            System.out.println("Guest não encontrado!");
            return;
        }

        guest.setStatus(newStatus);
    }
}
