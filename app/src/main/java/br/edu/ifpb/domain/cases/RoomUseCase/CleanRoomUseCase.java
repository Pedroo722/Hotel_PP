package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.RoomStatus;
import br.edu.ifpb.interfaces.controller.CleanRoomUseCaseIF;

public class CleanRoomUseCase implements CleanRoomUseCaseIF {
    private RoomRepositoryInterface repository;

    public void cleanRoom(Id roomId, RoomStatus statusClean) {
        Room room = repository.findRoomById(roomId);

        if(room == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        room.setStatus(statusClean);
    }
}
