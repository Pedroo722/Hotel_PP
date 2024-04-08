package br.edu.ifpb.presenter.controller;

import br.edu.ifpb.domain.wrappers.*;

import java.util.List;

import br.edu.ifpb.data.GuestRepository;
import br.edu.ifpb.domain.cases.GuestUseCase.*;
import br.edu.ifpb.domain.model.*;

public class GuestController {
    private GuestRepository repository;

    public GuestController() {
        this.repository = GuestRepository.getInstance();
    }

    public void addGuest(Name newName, CPF newCpf, GuestStatus status) {
        Guest newGuest = new Guest(newName, newCpf, status, null);
        repository.addGuest(newGuest);
    }

    public void listGuests() {
        List<Guest> guests = repository.getGuests();
        if (guests.isEmpty()) {
            System.out.println("\nA lista de convidados está vazia!\n");
            return;
        }

        int count = 1;
        System.out.println("\n== Lista de Hóspedes ==");
        for (Guest guest : guests) {
            System.out.println("Convidado: " + count);
            System.out.println(guest.toString());
            System.out.println();
            count++;
        }
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