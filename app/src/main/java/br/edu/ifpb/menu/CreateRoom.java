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

        List<Room> rooms = new ArrayList<>();

        RoomType smallRoomType = RoomTypeFactory.createRoomType("Single");
        RoomType mediumRoomType = RoomTypeFactory.createRoomType("Double");
        RoomType largeRoomType = RoomTypeFactory.createRoomType("Large");
        RoomType deluxeRoomType = RoomTypeFactory.createRoomType("Deluxe");

        roomTypeRepository.addRoomType(smallRoomType);
        roomTypeRepository.addRoomType(mediumRoomType);
        roomTypeRepository.addRoomType(largeRoomType);
        roomTypeRepository.addRoomType(deluxeRoomType);

        roomTypeRepository.saveRoomTypesToDB();

        Id smallRoomTypeId = smallRoomType.getRoomTypeId();
        Id mediumRoomTypeId = mediumRoomType.getRoomTypeId();
        Id largeRoomTypeId = largeRoomType.getRoomTypeId();
        Id deluxeRoomTypeId = deluxeRoomType.getRoomTypeId();

        int roomNumber = 1;
        RoomStatus status = RoomStatus.AVAILABLE;

        // 6 small rooms
        for (int i = 0; i < 6; i++) {
            rooms.add(Room.RoomBuilder.smallRoom()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(smallRoomTypeId)
                    .withStatus(status)
                    .build());
        }

        // 8 medium rooms
        for (int i = 0; i < 8; i++) {
            rooms.add(Room.RoomBuilder.mediumRoom()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(mediumRoomTypeId)
                    .withStatus(status)
                    .build());
        }

        // 4 large rooms
        for (int i = 0; i < 4; i++) {
            rooms.add(Room.RoomBuilder.largeRoom()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(largeRoomTypeId)
                    .withStatus(status)
                    .build());
        }

        // 2 deluxe rooms
        for (int i = 0; i < 2; i++) {
            rooms.add(Room.RoomBuilder.deluxeRoom()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(deluxeRoomTypeId)
                    .withStatus(status)
                    .build());
        }

        for (Room room : rooms) {
            roomRepository.addRoom(room);
            System.out.println(room.toString());
        }

        System.out.println("Rooms created successfully!");
    }
}
