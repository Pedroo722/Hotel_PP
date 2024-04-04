package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface GuestRepositoryInterface {
    public void saveGuests(Guest guest);
    public Guest findGuestById(Id id);
}