package br.edu.ifpb.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.cases.RoomTypeUseCase.CheckRoomTypeIdentityUseCase;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;;

public class RoomTypeRepository {
    private List<RoomType> roomTypes = new ArrayList<>();
    private static RoomTypeRepository instance;

    public static void main(String [] args) throws FileNotFoundException {
        RoomTypeRepository RoomTypeRepository = new RoomTypeRepository();

        RoomTypeRepository.saveRoomTypesToFile();
        RoomTypeRepository.loadRoomTypesFromFile();
    }

    // Padrão de Criação: Singleton
    public static RoomTypeRepository getInstance() {
        if (instance == null) {
        instance = new RoomTypeRepository();
        }
        return instance;
    }

    public void saveRoomTypesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("RoomTypes.bin"))) {
            out.writeObject(this.roomTypes);
            System.out.printf("Serialized data is saved in RoomTypes.bin\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RoomType> loadRoomTypesFromFile() {
        List<RoomType> loadedRooms = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RoomTypes.bin"))) {
            loadedRooms = (List<RoomType>) ois.readObject();
            System.out.printf("Room types loaded from RoomTypes.bin\n");
        } catch (FileNotFoundException e) {
            loadedRooms = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedRooms;
    }

    public void addRoom(RoomType roomType) {
        roomTypes.add(roomType);
    }

    public RoomType findRoomTypeById(Id id) {
        for (RoomType RoomType : this.roomTypes) {
            if (CheckRoomTypeIdentityUseCase.isSameRoomType(RoomType, id)) {
                return RoomType;
            }
        }
        return null;
    }
}