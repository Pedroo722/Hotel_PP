package br.edu.ifpb.interfaces;

import br.edu.ifpb.model.*;
import br.edu.ifpb.wrappers.*;

public interface GuestIF {
    public Guest updateGuest(Name newName, CPF newCpf, GuestStatus isHosted, RoomNumber roomNumber);

    public void updateStatus(boolean newStatus);

}
