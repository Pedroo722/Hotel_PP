package br.edu.ifpb.interfaces;

import br.edu.ifpb.model.*;
import br.edu.ifpb.wrappers.*;

public interface GuestIF {
    public void registerGuest(Id guestId); // alternar isHoted para true

    public void cancelRegistration(Id userId); // alterar isHosted para false
 
    public Guest updateGuest(Name newName, CPF newCpf, GuestStatus isHosted, RoomNumber roomNumber);


    public void checkIn(Id userId);

    public void checkOut(Id userId); 

}
