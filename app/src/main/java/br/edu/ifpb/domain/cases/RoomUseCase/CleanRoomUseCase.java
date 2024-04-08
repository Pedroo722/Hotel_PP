package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.interfaces.controller.CleanRoomUseCaseIF;

public class CleanRoomUseCase implements CleanRoomUseCaseIF {
    private RoomRepositoryInterface repository;

    public CleanRoomUseCase() {
        this.repository = RoomRepository.getInstance();
    }

    public void cleanRoom(Id roomId, RoomStatus statusClean) {
        Room room = repository.findRoomById(roomId);

        if(room == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        room.setStatus(statusClean);
    }
}
