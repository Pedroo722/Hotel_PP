package br.edu.ifpb.interfaces;

import br.edu.ifpb.model.Room;
import br.edu.ifpb.wrappers.*;

public interface RoomIF {
    public Room updateRoom(Id roomId, RoomNumber newNumber, Id newType, RoomStatus newStatus);

    public void removeRoom(Room room); 

    public void cleanRoom(Id roomId);
}
 