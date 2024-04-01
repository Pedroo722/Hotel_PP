package br.edu.ifpb.domain.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.GuestUseCase.CheckGuestIdentityUseCase;
import br.edu.ifpb.domain.wrappers.Id;

public class GuestCollections {
    private List<Guest> guestList;

    public GuestCollections() {
        this.guestList = new ArrayList<>();
    }

    public Guest searchGuest(Id userId) {
        for (Guest guest : guestList) {
            if (CheckGuestIdentityUseCase.isSameGuest(guest, userId)) {
                return guest;
            }
        }
        return null;
    }

    public List<Guest> consultGuestList() {
        return guestList;
    }

    public List<Guest> consultActiveGuest() {
        List<Guest> activeGuestList = new ArrayList<>();

        for (Guest guest : guestList) {
            if (guest.isHosted()) { 
                activeGuestList.add(guest);   
            }
        }   
        return activeGuestList;
    }
}
