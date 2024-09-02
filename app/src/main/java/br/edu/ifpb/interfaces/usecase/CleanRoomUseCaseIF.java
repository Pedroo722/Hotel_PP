package br.edu.ifpb.interfaces.usecase;

import br.edu.ifpb.domain.wrappers.*;

public interface CleanRoomUseCaseIF {
    public void cleanRoom(Id roomId, RoomStatus statusClean);
}
