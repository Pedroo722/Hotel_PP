package br.edu.ifpb.data;

import java.io.Serializable;
import java.util.*;

import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;

public class RoomRepository implements RoomRepositoryInterface, Serializable {
    private static RoomRepository instance;
    private List<Room> rooms = new ArrayList<>();

    private RoomRepository() {
        this.rooms = new ArrayList<>();
    }


    public static RoomRepository getInstance() {
        if (instance == null) { instance = new RoomRepository(); }
        return instance;
    }

    // Metodo para salvar Rooms no Banco de Dados
    // public void saveRoomsToFile() {
    //     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Rooms.bin"))) {
    //         out.writeObject(this.rooms);
    //         System.out.printf("Serialized data is saved in Rooms.bin\n");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // Metodo para retirar Rooms do Banco de Dados
    // public List<Room> loadRoomsFromFile() {
    //     List<Room> loadedRooms = null;
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Rooms.bin"))) {
    //         loadedRooms = (List<Room>) ois.readObject();
    //         System.out.printf("Rooms loaded from Rooms.bin\n");
    //     } catch (FileNotFoundException e) {
    //         loadedRooms = new ArrayList<>();
    //     } catch (IOException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    //     return loadedRooms;
    // }

    public void addRoom(Room room) {
        rooms.add(room);
        // saveRoomsToFile();
    }

    public void updateRoom(Room updateRoom) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getRoomId().equals(updateRoom.getRoomId())) {
                rooms.set(i, updateRoom);
                // saveRoomsToFile();
                return;
            }
        }
        throw new ReserveNotFoundException();
    }

    public void removeRoom(RoomNumber roomNumber) {
        rooms.removeIf(room -> room.getNumber().equals(roomNumber));
        // saveReservesToFile();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room findRoomByNumber(RoomNumber roomNumber) {
        for (Room room : rooms) {
            if (CheckRoomIdentityUseCase.isSameRoom(room, roomNumber)) {
                return room;
            }
        }
        throw new RoomNotFoundException();
    }
}