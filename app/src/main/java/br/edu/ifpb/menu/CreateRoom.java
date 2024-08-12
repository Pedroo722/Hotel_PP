package br.edu.ifpb.menu;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.data.RoomTypeRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class CreateRoom {
    public static void main(String[] args) {
        RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();
        RoomRepository roomRepository = RoomRepository.getInstance();
        List<RoomType> roomTypeList = roomTypeRepository.loadRoomTypesFromFile();

        // int count = 1;
        // for (RoomType roomType : roomTypeList) {
        //     System.out.println("Tipo " + count + ':');
        //     System.out.println(roomType.toString());
        //     count++;
        // }

        List<Room> rooms = new ArrayList<>();

        int roomNumber = 1;
        for (RoomType roomType : roomTypeList) {
            int numRoomsToAdd;
            if (roomType.getDescription() == RoomDescription.SMALL) {
                numRoomsToAdd = 6;
            } else if (roomType.getDescription() == RoomDescription.MEDIUM) {
                numRoomsToAdd = 8;
            } else if (roomType.getDescription() == RoomDescription.LARGE) {
                numRoomsToAdd = 4;
            } else { // RoomDescription.LUXURY
                numRoomsToAdd = 2;
            }

            for (int i = 0; i < numRoomsToAdd; i++) {
                Room room = new Room.RoomBuilder()
                        .withNumber(new RoomNumber(roomNumber))
                        .withRoomType(roomType)
                        .withStatus(RoomStatus.AVAILABLE)
                        .build();
                System.out.println(room.toString());
                rooms.add(room);
                roomNumber++;
            }
        }

        // Salva os quartos no arquivo
        for (Room room : rooms) {
            roomRepository.addRoom(room);
        }

        // roomRepository.saveRoomsToFile();

        System.out.println("Quartos criados com sucesso!");       
    }
}
