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
        try {
            List<Room> rooms = repository.getRooms();
            if (rooms.isEmpty()) {
                throw new NoRoomsAvailableException("A lista de quartos está vazia.");
            }

            int count = 1;
            System.out.println("\n== Lista de Quartos ==");
            for (Room room : rooms) {
                System.out.println("Quarto: #" + count);
                System.out.println(room.toString());
                count++;
            }
        } catch (NoRoomsAvailableException e) {
            System.out.println(e.getMessage()); // Tratamento da exceção
        }
    }

    public void listAvailableRooms() {
        try {
            List<Room> rooms = repository.getRooms();
            if (rooms.isEmpty()) {
                throw new NoRoomsAvailableException("Não há quartos disponíveis.");
            }

            boolean availableRoomsFound = false;
            System.out.println("\n== Opções de Quartos Disponíveis ==");
            for (Room room : rooms) {
                if (CheckRoomStatusUseCase.isRoomAvailable(room)) {
                    availableRoomsFound = true;
                    System.out.println("* Número: " + room.getNumber().toString() +
                            " | Tipo de Quarto: " + room.getRoomTypeId().toString() +
                            " | Status: " + room.getStatus());
                }
            }

            if (!availableRoomsFound) {
                throw new NoRoomsAvailableException("Nenhum quarto disponível no momento.");
            }

            System.out.println();
        } catch (NoRoomsAvailableException e) {
            System.out.println(e.getMessage()); // Tratamento da exceção
        }
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