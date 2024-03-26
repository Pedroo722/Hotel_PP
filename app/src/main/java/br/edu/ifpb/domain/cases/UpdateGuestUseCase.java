package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateGuestUseCaseIF;

public class UpdateGuestUseCase implements UpdateGuestUseCaseIF {
    public void updateGuest(Guest guest, Name newName, CPF newCpf, GuestStatus newStatus, Id newReserveId) {
        guest.setName(newName);
        guest.setCpf(newCpf);
        guest.setStatus(newStatus);
        guest.setReserveId(newReserveId);
    }
}
