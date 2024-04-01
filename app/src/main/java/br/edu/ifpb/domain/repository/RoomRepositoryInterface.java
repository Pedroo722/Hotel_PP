package br.edu.ifpb.domain.repository;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface RoomRepositoryInterface {
    public void save(Room room);
    public Room findRoomById(Id id);
    public void updateRoom(Room Room);
}
