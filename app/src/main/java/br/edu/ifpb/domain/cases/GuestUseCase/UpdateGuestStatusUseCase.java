package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class UpdateGuestStatusUseCase {
    private GuestRepository repository;

    public UpdateGuestStatusUseCase() {
        this.repository = GuestRepository.getInstance();
    }

    public void updateStatus(Id userId) {
        Guest guest = repository.findGuestById(userId);
        GuestStatus currentStatus = guest.getStatus();
        
        if (currentStatus == GuestStatus.HOSTED) {
            String statusStr = "NOT_HOSTED";
            GuestStatus canceledStatus = GuestStatus.valueOf(statusStr);
            guest.setStatus(canceledStatus);
            return;
        }

        String statusStr = "HOSTED";
        GuestStatus activeStatus = GuestStatus.valueOf(statusStr);
        guest.setStatus(activeStatus);
    }
}
