package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface RoomRepositoryInterface {
    public void saveRooms(Room room);
    public Room findRoomById(Id id);
}
