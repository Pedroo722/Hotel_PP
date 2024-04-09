package br.edu.ifpb.domain.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.Id;

public interface RoomRepositoryInterface {
    public Room findRoomById(Id id);
    public List<Room> loadRoomsFromFile();
}
