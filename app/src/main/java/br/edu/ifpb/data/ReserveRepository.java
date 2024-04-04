package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.ReserveUseCase.CheckReserveIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.ReserveRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;;

public class ReserveRepository implements ReserveRepositoryInterface {
    private List<Reserve> Reserves = new ArrayList<>();

    public static void main(String [] args) throws FileNotFoundException {
        ReserveRepository ReserveRepository = new ReserveRepository();

        ReserveRepository.saveReservesToFile();
        ReserveRepository.loadReservesFromFile();
    }

    // Serialização de Reserves
    private void saveReservesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Reserves.bin"))) {
            out.writeObject(this.Reserves);
            System.out.printf("Serialized data is saved in Reserves.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialização de Reserves
    private void loadReservesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Reserves.bin"))) {
            this.Reserves = (List<Reserve>) ois.readObject();
            System.out.printf("Reserves loaded from Reserves.bin\n");
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, não faz nada
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveReserves(Reserve Reserve) {
        //
    }

    public Reserve findReserveById(Id id) {
        for (Reserve Reserve : this.Reserves) {
            if (CheckReserveIdentityUseCase.isSameReserve(Reserve, id)) {
                return Reserve;
            }
        }
        return null;
    }
}