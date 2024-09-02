package br.edu.ifpb.interfaces.usecase;

import br.edu.ifpb.domain.wrappers.GuestStatus;
import br.edu.ifpb.domain.wrappers.Id;

public interface UpdateGuestStatusUseCaseIF {
    public void updateStatus(Id useId, GuestStatus newStatus);   
}
