package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface GuestRepositoryInterface {
    public void save(Guest guest);
    public Guest findGuestById(Id id);
    public void updateGuest(Guest guest);
}