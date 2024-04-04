package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.*;

public interface UpdateGuestUseCaseIF {
    public void updateGuest(Id useriId, Name newName, CPF newCpf, GuestStatus status, Id newReserveId);
}
