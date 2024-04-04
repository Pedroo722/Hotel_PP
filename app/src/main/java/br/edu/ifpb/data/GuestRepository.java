package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.GuestUseCase.CheckGuestIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;;

public class GuestRepository implements GuestRepositoryInterface {
    private List<Guest> guests = new ArrayList<>();

    public static void main(String [] args) throws FileNotFoundException {
        GuestRepository guestRepository = new GuestRepository();

        guestRepository.saveGuestsToFile();
        guestRepository.loadGuestsFromFile();
    }

    // Serialização de Guests
    private void saveGuestsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Guests.bin"))) {
            out.writeObject(this.guests);
            System.out.printf("Serialized data is saved in Guests.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialização de Guests
    private void loadGuestsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Guests.bin"))) {
            this.guests = (List<Guest>) ois.readObject();
            System.out.printf("Guests loaded from Guests.bin\n");
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, não faz nada
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveGuests(Guest guest) {
        //
    }

    public Guest findGuestById(Id id) {
        for (Guest guest : this.guests) {
            if (CheckGuestIdentityUseCase.isSameGuest(guest, id)) {
                return guest;
            }
        }
        return null;
    }
}