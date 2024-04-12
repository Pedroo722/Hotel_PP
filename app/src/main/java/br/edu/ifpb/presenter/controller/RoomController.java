package br.edu.ifpb.presenter.controller;


import java.util.List;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.cases.RoomUseCase.*;
import br.edu.ifpb.domain.model.*;

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

        System.out.println("\n== Quartos Disponíveis ==");
        int count = 1;
        for (Room room : rooms) {
            if (CheckRoomStatusUseCase.isRoomAvailable(room)) {
                System.out.println("Quarto: #" + count);
                System.out.println(room.toString());
                count++;
            }
        }
    }

    public void handleFinish() {
        // repository.saveRoomsToFile();
    }
}