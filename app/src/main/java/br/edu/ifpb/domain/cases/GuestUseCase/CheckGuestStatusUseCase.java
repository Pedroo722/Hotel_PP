package br.edu.ifpb.domain.cases.GuestUseCase;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class CheckGuestStatusUseCase {
    public static boolean isGuestAvailable(Guest guest) {
        return guest.getStatus() == GuestStatus.NOT_HOSTED;
    }
}
