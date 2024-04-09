package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.ReserveUseCase.CheckReserveIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;;

public class ReserveRepository implements ReserveRepositoryInterface {
    private List<Reserve> reserves = new ArrayList<>();
    private static ReserveRepository instance;

    public static void main(String [] args) throws FileNotFoundException {
        ReserveRepository ReserveRepository = new ReserveRepository();

        ReserveRepository.saveReservesToFile();
        ReserveRepository.loadReservesFromFile();
    }

    public static ReserveRepository getInstance() {
        if (instance == null) {
        instance = new ReserveRepository();
        }
        return instance;
    }

    public void saveReservesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Reserves.bin"))) {
            out.writeObject(this.reserves);
            System.out.printf("Serialized data is saved in Reserves.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Reserve> loadReservesFromFile() {
        List<Reserve> loadedReserves = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Reserves.bin"))) {
            loadedReserves = (List<Reserve>) ois.readObject();
            System.out.printf("Reserves loaded from Reserves.bin\n");
        } catch (FileNotFoundException e) {
            loadedReserves = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedReserves;
    }

    public void addReserve(Reserve reserve) {
        reserves.add(reserve);
    }

    public Reserve findReserveById(Id id) {
        for (Reserve Reserve : this.reserves) {
            if (CheckReserveIdentityUseCase.isSameReserve(Reserve, id)) {
                return Reserve;
            }
        }
        return null;
    }
}