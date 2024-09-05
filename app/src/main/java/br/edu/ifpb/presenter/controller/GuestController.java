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


    public void addGuest(Name newName, CPF newCpf) {
        Guest newGuest = new Guest(newName, newCpf);
        repository.addGuest(newGuest);
    }

    public void listGuests() {
        List<Guest> guests = repository.getGuests();

        if (guests.isEmpty()) {
            System.out.print("\nA lista de convidados está vazia!\n");
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

    public List<Guest> getListGuests() {
        return repository.getGuests();
    }

    public void editGuest(Id id, Name newName, CPF newCPF) {
        UpdateGuestUseCase updateGuestUseCase = new UpdateGuestUseCase();
        updateGuestUseCase.updateGuest(id, newName, newCPF);
    }

    public void removeGuest(Id id) {    
        RemoveGuestUseCase removeGuestUseCase = new RemoveGuestUseCase();
        removeGuestUseCase.removeGuest(id);
    }    

    public Guest getGuestById(Id guestId) {
        return repository.findGuestById(guestId);
    }

    public void handleFinish() {
        repository.saveGuestsToDB();
    }
}