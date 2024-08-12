package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.repository.RoomRepositoryInterface;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.RoomNotFoundException;

public class UpdateRoomStatusUseCase {
    private RoomRepositoryInterface repository;

    public UpdateRoomStatusUseCase() {
        this.repository = RoomRepository.getInstance();
    }

    public UpdateRoomStatusUseCase(RoomRepositoryInterface repository) {
        this.repository = repository;
    }

    public void updateRoomStatus(RoomNumber roomNumber) {
        Room room = repository.findRoomByNumber(roomNumber);
        if (room == null) {
            throw new RoomNotFoundException();
        }
        RoomStatus currentStatus = room.getStatus();
        
        // Disponível -> Ocupado ou Ocupado -> Disponível
        RoomStatus newStatus = currentStatus == RoomStatus.AVAILABLE ? RoomStatus.OCCUPIED : RoomStatus.AVAILABLE;

        room.setStatus(newStatus);

        repository.updateRoom(room);
    }
}
