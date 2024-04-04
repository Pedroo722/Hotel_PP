package br.edu.ifpb.interfaces.controller;

import br.edu.ifpb.domain.wrappers.*;

public interface CleanRoomUseCaseIF {
    public void cleanRoom(Id roomId, RoomStatus statusClean);
}
