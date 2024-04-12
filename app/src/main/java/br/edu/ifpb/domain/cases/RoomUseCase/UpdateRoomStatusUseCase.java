package br.edu.ifpb.domain.cases.RoomUseCase;

import br.edu.ifpb.data.RoomRepository;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public class UpdateRoomStatusUseCase {
    private RoomRepository repository;

    public UpdateRoomStatusUseCase() {
        this.repository = RoomRepository.getInstance();
    }

    public void updateRoomStatus(RoomNumber roomNumber) {
        Room room = repository.findRoomByNumber(roomNumber);
        RoomStatus currentStatus = room.getStatus();
        
        // Disponível -> Ocupado
        if (currentStatus == RoomStatus.AVAILABLE) {
            String statusStr = "OCCUPIED";
            RoomStatus occupiedStatus = RoomStatus.valueOf(statusStr);
            room.setStatus(occupiedStatus);
            return;
        }

        // Ocupado -> Disponível
        String statusStr = "AVAILABLE";
        RoomStatus availableStatus = RoomStatus.valueOf(statusStr);
        room.setStatus(availableStatus);
    }
}
