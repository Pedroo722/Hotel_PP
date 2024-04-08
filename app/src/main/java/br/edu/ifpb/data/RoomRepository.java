package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.RoomUseCase.CheckRoomIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;;

public class RoomRepository implements RoomRepositoryInterface {
    private List<Room> Rooms = new ArrayList<>();
    private static RoomRepository instance;

    public static void main(String [] args) throws FileNotFoundException {
        RoomRepository RoomRepository = new RoomRepository();

        RoomRepository.saveRoomsToFile();
        RoomRepository.loadRoomsFromFile();
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
        instance = new RoomRepository();
        }
        return instance;
    }

    // Serialização de Rooms
    private void saveRoomsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
            out.writeObject(this.Rooms);
            System.out.printf("Serialized data is saved in Rooms.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialização de Rooms
    private void loadRoomsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
            this.Rooms = (List<Room>) ois.readObject();
            System.out.printf("Rooms loaded from Rooms.bin\n");
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, não faz nada
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveRooms(Room Room) {
        //
    }

    public Room findRoomById(Id id) {
        for (Room Room : this.Rooms) {
            if (CheckRoomIdentityUseCase.isSameRoom(Room, id)) {
                return Room;
            }
        }
        return null;
    }
}