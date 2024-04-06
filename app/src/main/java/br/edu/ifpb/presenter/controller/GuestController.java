package br.edu.ifpb.presenter.controller;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.model.*;

public class GuestController {
    public void addGuest(Name newName, CPF newCpf, GuestStatus status) {
        new Guest(newName, newCpf, status, null);
    }

    // TODO
    public void listGuests() {
        // List<Guest> guests = repository.getGuests();
    
        // // Exibir a lista de hóspedes
        // for (Guest guest : guests) {
        //     System.out.println(guest);
        // }
    }
    

    public void editGuest(Id id, Name newName, CPF newCPF, GuestStatus newStatus, Id reserveId) {
        UpdateGuestUseCase updateGuestUseCase = new UpdateGuestUseCase();
        updateGuestUseCase.updateGuest(id, newName, newCPF, newStatus, reserveId);
    }

    public void removeGuest(Id id) {    
        RemoveGuestUseCase removeGuestUseCase = new RemoveGuestUseCase();
        removeGuestUseCase.removeGuest(id);
    }    
}