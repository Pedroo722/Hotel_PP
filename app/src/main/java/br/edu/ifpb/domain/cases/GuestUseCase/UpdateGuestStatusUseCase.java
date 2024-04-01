package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateGuestStatusUseCaseIF;

public class UpdateGuestStatusUseCase implements UpdateGuestStatusUseCaseIF {
    public void updateStatus(Guest guest, GuestStatus newStatus) {
        guest.setStatus(newStatus);
    }
}
