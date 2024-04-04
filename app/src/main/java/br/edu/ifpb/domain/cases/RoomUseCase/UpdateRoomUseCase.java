package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.interfaces.controller.UpdateRoomUseCaseIF;

public class UpdateRoomUseCase implements UpdateRoomUseCaseIF {
    private RoomRepositoryInterface repository;

    public void updateRoom(Id roomId, RoomNumber newNumber, Id newRoomTypeId, RoomStatus newStatus) {
        Room room = repository.findRoomById(roomId);

        if(room == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        room.setNumber(newNumber);
        room.setRoomTypeId(newRoomTypeId);
        room.setStatus(newStatus);
    }
}
