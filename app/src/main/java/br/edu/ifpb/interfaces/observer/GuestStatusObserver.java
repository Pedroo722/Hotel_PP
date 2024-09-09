package br.edu.ifpb.interfaces.observer;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class GuestStatusObserver implements Observer<Guest> {
    @Override
    public void update(Guest guest) {
        if (guest.getStatus() == GuestStatus.NOT_HOSTED) {
            guest.setReserveId(null); 
        }
    }
}
