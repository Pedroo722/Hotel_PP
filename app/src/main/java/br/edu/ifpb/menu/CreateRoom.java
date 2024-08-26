package br.edu.ifpb.menu;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class CreateRoom {
    public static void main(String[] args) {
        RoomRepository roomRepository = RoomRepository.getInstance();

        List<Room> rooms = new ArrayList<>();

        // Create room types and store their IDs
        Id smallRoomTypeId = RoomTypeFactory.createRoomType("Single").getRoomTypeId();
        Id mediumRoomTypeId = RoomTypeFactory.createRoomType("Double").getRoomTypeId();
        Id largeRoomTypeId = RoomTypeFactory.createRoomType("Large").getRoomTypeId();
        Id deluxeRoomTypeId = RoomTypeFactory.createRoomType("Deluxe").getRoomTypeId();

        int roomNumber = 1;

        // 6 small rooms
        for (int i = 0; i < 6; i++) {
            rooms.add(new Room.RoomBuilder()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(smallRoomTypeId) // Use RoomTypeId
                    .withStatus(RoomStatus.AVAILABLE)
                    .build());
        }

        // 8 medium rooms
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room.RoomBuilder()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(mediumRoomTypeId) // Use RoomTypeId
                    .withStatus(RoomStatus.AVAILABLE)
                    .build());
        }

        // 4 large rooms
        for (int i = 0; i < 4; i++) {
            rooms.add(new Room.RoomBuilder()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(largeRoomTypeId) // Use RoomTypeId
                    .withStatus(RoomStatus.AVAILABLE)
                    .build());
        }

        // 2 deluxe rooms
        for (int i = 0; i < 2; i++) {
            rooms.add(new Room.RoomBuilder()
                    .withNumber(new RoomNumber(roomNumber++))
                    .withRoomTypeId(deluxeRoomTypeId) // Use RoomTypeId
                    .withStatus(RoomStatus.AVAILABLE)
                    .build());
        }

        // Save in RoomRepository
        for (Room room : rooms) {
            roomRepository.addRoom(room);
            System.out.println(room.toString());
        }

        System.out.println("Rooms created successfully!");
    }
}
