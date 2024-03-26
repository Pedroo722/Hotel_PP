package br.edu.ifpb.domain.interfaces;

import br.edu.ifpb.domain.model.Room;
import br.edu.ifpb.domain.wrappers.*;

public interface RoomIF {
    public void removeRoom(Room room); 

    public void cleanRoom(Id roomId);
}
 