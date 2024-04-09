package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.interfaces.controller.RemoveRoomUseCaseIF;

public class RemoveRoomUseCase implements RemoveRoomUseCaseIF {
    private RoomRepositoryInterface repository;

    public RemoveRoomUseCase() {
        this.repository = RoomRepository.getInstance();
    }

    public void removeRoom(Id userId) {
        Room room = repository.findRoomById(userId);

        if(room == null) {
            // System.out.println("Guest não encontrado!");
            return;
        }

        repository.loadRoomsFromFile().remove(room);
    }
}
