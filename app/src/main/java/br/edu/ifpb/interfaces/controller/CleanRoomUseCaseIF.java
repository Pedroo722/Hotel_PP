package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.RoomStatus;

public interface CleanRoomUseCaseIF {
    public void cleanRoom(Room room, RoomStatus statusClean);
}
