package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.wrappers.Id;

public class GuestCollections {
    private List<Guest> guestList;

    public GuestCollections() {
        this.guestList = new ArrayList<>();
    }

    public Guest searchGuest(Id userId) {
        for (Guest guest : guestList) {
            if (guest.isSameGuest(userId)) {
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
            if (guest.IsHosted) { // checa se ishosted é true
                // adicionar a activeGuestList
                }
            }   
        return activeGuestList;
    }
}
