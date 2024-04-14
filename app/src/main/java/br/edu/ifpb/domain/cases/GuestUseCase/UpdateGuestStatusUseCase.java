package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;

public class UpdateGuestStatusUseCase {
    private GuestRepositoryInterface repository;

    public UpdateGuestStatusUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public void updateGuestStatus(Id userId) {
        Guest guest = repository.findGuestById(userId);
        GuestStatus currentStatus = guest.getStatus();
        
        if (currentStatus == GuestStatus.HOSTED) {
            String statusStr = "NOT_HOSTED";
            GuestStatus canceledStatus = GuestStatus.valueOf(statusStr);
            guest.setStatus(canceledStatus);
            repository.updateGuest(guest);
            return;
        }

        String statusStr = "HOSTED";
        GuestStatus activeStatus = GuestStatus.valueOf(statusStr);
        guest.setStatus(activeStatus);
        repository.updateGuest(guest);
    }
}
