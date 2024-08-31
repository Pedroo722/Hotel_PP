package br.edu.ifpb.interfaces.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface GuestRepositoryInterface {
    public Guest findGuestById(Id id);
    public void addGuest(Guest guest);
    public void updateGuest(Guest updatedGuest);
    public void removeGuest(Id id);
    public List<Guest> getGuests();
    // public List<Guest> loadGuestsFromFile();
}