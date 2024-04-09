package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.RoomUseCase.CheckRoomIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;;

public class RoomRepository implements RoomRepositoryInterface {
    private List<Room> rooms = new ArrayList<>();
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

    public void saveRoomsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
            out.writeObject(this.rooms);
            System.out.printf("Serialized data is saved in Rooms.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Room> loadRoomsFromFile() {
        List<Room> loadedRooms = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
            loadedRooms = (List<Room>) ois.readObject();
            System.out.printf("Rooms loaded from Rooms.bin\n");
        } catch (FileNotFoundException e) {
            loadedRooms = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedRooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findRoomById(Id id) {
        for (Room Room : this.rooms) {
            if (CheckRoomIdentityUseCase.isSameRoom(Room, id)) {
                return Room;
            }
        }
        return null;
    }
}