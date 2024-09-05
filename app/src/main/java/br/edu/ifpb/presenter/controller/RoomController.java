package br.edu.ifpb.presenter.controller;


import java.util.List;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.RoomNumber;

public class RoomController {
    private RoomRepository repository;

    public RoomController() {
        this.repository = RoomRepository.getInstance();
    }

    public void listRooms() {
        List<Room> rooms = repository.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("\nA lista de quartos está vazia!\n");
            return;
        }

        int count = 1;
        System.out.println("\n== Lista de Quartos ==");
        for (Room room : rooms) {
            System.out.println("Quarto: #" + count);
            System.out.println(room.toString());
            count++;
        }
    }

    public void listAvailableRooms() {
        List<Room> rooms = repository.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("\nNão há quartos disponíveis!\n");
            return;
        }
    
        System.out.println("\n== Opções de Quartos Disponíveis ==");
        for (Room room : rooms) {
            if (CheckRoomStatusUseCase.isRoomAvailable(room)) {
                System.out.println("* Número: " + room.getNumber().toString() +
                                   " | Tipo de Quarto: " + room.getRoomTypeId().toString() +
                                   " | Status: " + room.getStatus());
            }
        }
        System.out.println();
    }    

    public List<Room> getListRooms() {
        return repository.getRooms();
    }

    public Room getRoomByNumber(RoomNumber roomNumber) {
        return repository.findRoomByNumber(roomNumber);
    }

    public void handleFinish() {
        repository.saveRoomsToDB();
    }
}