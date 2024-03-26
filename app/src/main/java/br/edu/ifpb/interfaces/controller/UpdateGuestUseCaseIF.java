package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface UpdateGuestUseCaseIF {
    public void updateGuest(Guest guest, Name newName, CPF newCpf, GuestStatus status, Id newReserveId);
}
