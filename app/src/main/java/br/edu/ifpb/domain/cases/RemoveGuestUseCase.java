package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.interfaces.controller.RemoveGuestUseCaseIF;

public class RemoveGuestUseCase implements RemoveGuestUseCaseIF {
    public void removeGuest(Guest guest) {
        guest = null;
    }
}
