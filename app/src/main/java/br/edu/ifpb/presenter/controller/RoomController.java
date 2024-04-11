package br.edu.ifpb.presenter.controller;

import br.edu.ifpb.domain.wrappers.*;

import java.util.List;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;

public class RoomController {
    private RoomRepository repository;

    public RoomController() {
        this.repository = RoomRepository.getInstance();
    }

    public void addRoom(RoomNumber newNumber, RoomType roomType, RoomStatus status) {
        Room newRoom = new Room(newNumber, roomType, status);
        repository.addRoom(newRoom);
    }

    public void listRooms() {
        List<Room> rooms = repository.loadRoomsFromFile();
        if (rooms.isEmpty()) {
            System.out.println("\nA lista de quartos está vazia!\n");
            return;
        }

        int count = 1;
        System.out.println("\n== Lista de Quartos ==");
        for (Room room : rooms) {
            System.out.println("Quarto: #" + count);
            System.out.println(room.toString());
            System.out.println();
            count++;
        }
    }

    public void editRoom(Id id, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus) {
        UpdateRoomUseCase updateRoomUseCase = new UpdateRoomUseCase();
        updateRoomUseCase.updateRoom(id, newNumber, newRoomTypeId, newStatus);
    }

    public void removeRoom(Id id) {    
        RemoveRoomUseCase removeRoomUseCase = new RemoveRoomUseCase();
        removeRoomUseCase.removeRoom(id);
    }    

    public void handleFinish() {
        repository.saveRoomsToFile();
    }
}