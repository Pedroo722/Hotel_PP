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
        try {
            if (newName == null || newCpf == null) {
                throw new InvalidGuestDataException("Nome ou CPF inválido!");
            }
            Guest newGuest = new Guest(newName, newCpf);
            repository.addGuest(newGuest);
        } catch (InvalidGuestDataException e) {
            System.out.println("Erro ao adicionar convidado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao adicionar convidado: " + e.getMessage());
        }
    }

    public void listGuests() {
        try {
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
        } catch (Exception e) {
            System.out.println("Erro ao listar convidados: " + e.getMessage());
        }
    }

    public List<Guest> getListGuests() {
        try {
            return repository.getGuests();
        } catch (Exception e) {
            System.out.println("Erro ao obter lista de convidados: " + e.getMessage());
            return null;
        }
    }

    public void editGuest(Id id, Name newName, CPF newCPF) {
        try {
            UpdateGuestUseCase updateGuestUseCase = new UpdateGuestUseCase();
            if (id == null || newName == null || newCPF == null) {
                throw new InvalidGuestDataException("Dados inválidos para a atualização do convidado.");
            }
            updateGuestUseCase.updateGuest(id, newName, newCPF);
        } catch (InvalidGuestDataException e) {
            System.out.println("Erro ao editar convidado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao editar convidado: " + e.getMessage());
        }
    }

    public void removeGuest(Id id) {
        try {
            if (id == null) {
                throw new GuestNotFoundException("Convidado com ID " + id + " não encontrado.");
            }
            RemoveGuestUseCase removeGuestUseCase = new RemoveGuestUseCase();
            removeGuestUseCase.removeGuest(id);
        } catch (GuestNotFoundException e) {
            System.out.println("Erro ao remover convidado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao remover convidado: " + e.getMessage());
        }
    }

    public Guest getGuestById(Id guestId) {
        try {
            Guest guest = repository.findGuestById(guestId);
            if (guest == null) {
                throw new GuestNotFoundException("Convidado com ID " + guestId + " não encontrado.");
            }
            return guest;
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erro inesperado ao buscar convidado: " + e.getMessage());
            return null;
        }
    }

    public void handleFinish() {
        try {
            repository.saveGuestsToDB();
        } catch (Exception e) {
            System.out.println("Erro ao salvar convidados no banco de dados: " + e.getMessage());
        }
    }
}