package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.wrappers.GuestStatus;

public interface UpdateGuestStatusUseCaseIF {
    public void updateStatus(Guest guest, GuestStatus newStatus);   
}
