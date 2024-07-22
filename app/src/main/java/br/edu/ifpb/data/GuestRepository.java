package br.edu.ifpb.data;

import java.io.*;
import java.util.*;

import br.edu.ifpb.domain.cases.GuestUseCase.CheckGuestIdentityUseCase;
import br.edu.ifpb.domain.model.Guest;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.exceptions.GuestNotFoundException;

public class GuestRepository implements GuestRepositoryInterface, Serializable {
    private static GuestRepository instance;
    private List<Guest> guests;

    private GuestRepository() {
        this.guests = new ArrayList<>();
    }

    public static GuestRepository getInstance() {
        if (instance == null) { instance = new GuestRepository(); }
        return instance;
    }

    // Metodo para salvar Guests no Banco de Dados
    // public void saveGuestsToFile() {
    //     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin", true))) {
    //         out.writeObject(this.guests);
    //         System.out.println("Serialized data is saved in Guests.bin");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // Metodo para retirar os Guests do Banco de Dados
    // public void loadGuestsFromFile() {
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Guests.bin"))) {
    //         this.guests = (List<Guest>) ois.readObject();
    //         System.out.println("Guests loaded from Guests.bin");
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Guests file not found. Creating new guest list.");
    //         this.guests = new ArrayList<>();
    //     } catch (IOException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    // }

    public void addGuest(Guest guest) {
        guests.add(guest);
        // saveGuestsToFile();
    }

    public void updateGuest(Guest updatedGuest) {
        for (int i = 0; i < guests.size(); i++) {
            Guest guest = guests.get(i);
            if (guest.getUserId().equals(updatedGuest.getUserId())) {
                guests.set(i, updatedGuest);
                // saveGuestsToFile();
                return;
            }
        }
        throw new GuestNotFoundException();
    }

    public void removeGuest(Id id) {
        guests.removeIf(guest -> guest.getUserId().equals(id));
        // saveGuestsToFile();
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public Guest findGuestById(Id id) {
        for (Guest guest : guests) {
            if (CheckGuestIdentityUseCase.isSameGuest(guest, id)) {
                return guest;
            }
        }
        throw new GuestNotFoundException();
    }
}
