package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;

public class RoomType {
    Id typeId;
    RoomCapacity capacity;
    RoomSize roomSize;

    public RoomType(RoomCapacity capacity, RoomSize roomSize) {
        this.typeId = new Id();;
        this.capacity = capacity;
        this.roomSize = roomSize;
    }
}
