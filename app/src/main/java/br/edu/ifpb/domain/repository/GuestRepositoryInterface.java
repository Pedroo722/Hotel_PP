package br.edu.ifpb.domain.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface GuestRepositoryInterface {
    public void saveGuests(Guest guest);
    public Guest findGuestById(Id id);
    public List<Guest> getGuests();
}