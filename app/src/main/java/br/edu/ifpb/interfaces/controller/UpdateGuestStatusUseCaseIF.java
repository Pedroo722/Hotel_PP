package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.GuestStatus;
import br.edu.ifpb.domain.wrappers.Id;

public interface UpdateGuestStatusUseCaseIF {
    public void updateStatus(Id useId, GuestStatus newStatus);   
}
