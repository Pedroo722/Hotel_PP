package br.edu.ifpb.data;

import java.util.*;

import br.edu.ifpb.domain.cases.ReserveUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

public class ReserveRepository {
    private List<Reserve> reserves = new ArrayList<>();
    private static ReserveRepository instance;

    private ReserveRepository() {
        this.reserves = new ArrayList<>();
    }

    public static ReserveRepository getInstance() {
        if (instance == null) { instance = new ReserveRepository(); }
        return instance;
    }

    // public void saveReservesToFile() {
    //     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Reserves.bin"))) {
    //         out.writeObject(this.reserves);
    //         System.out.printf("Serialized data is saved in Reserves.bin\n");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public List<Reserve> loadReservesFromFile() {
    //     List<Reserve> loadedReserves = null;
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Reserves.bin"))) {
    //         loadedReserves = (List<Reserve>) ois.readObject();
    //         System.out.printf("Reserves loaded from Reserves.bin\n");
    //     } catch (FileNotFoundException e) {
    //         loadedReserves = new ArrayList<>();
    //     } catch (IOException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    //     return loadedReserves;
    // }

    public void addReserve(Reserve reserve) {
        reserves.add(reserve);
        // saveReservesToFile();
    }

    public void updateReserve(Reserve updateReserve) {
        for (int i = 0; i < reserves.size(); i++) {
            Reserve reserve = reserves.get(i);
            if (reserve.getUserId().equals(updateReserve.getUserId())) {
                reserves.set(i, updateReserve);
                // saveReservesToFile();
                return;
            }
        }
        throw new ReserveNotFoundException();
    }

    public void removeReserve(Id id) {
        reserves.removeIf(reserve -> reserve.getReserveId().equals(id));
        // saveReservesToFile();
    }

    public List<Reserve> getReserves() {
        return reserves;
    }


    public Reserve findReserveById(Id id) {
        for (Reserve reserve : reserves) {
            if (CheckReserveIdentityUseCase.isSameReserve(reserve, id)) {
                return reserve;
            }
        }
        throw new GuestNotFoundException();
    }
}