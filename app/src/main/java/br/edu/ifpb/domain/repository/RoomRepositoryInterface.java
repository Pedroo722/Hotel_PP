package br.edu.ifpb.domain.repository;

import java.util.List;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

public interface RoomRepositoryInterface {
    public Room findRoomByNumber(RoomNumber roomNumber);
    public void addRoom(Room room);
    public void updateRoom(Room updatedRoom);
    public List<Room> getRooms();
    // public List<Room> loadRoomsFromFile();
}
