package br.edu.ifpb.domain.cases;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.model.Guest;

public class CheckGuestIdentityUseCase {
    public static boolean isSameGuest(Guest guest, Id userId) {
        return guest.getUserId().equals(userId);
    }
}