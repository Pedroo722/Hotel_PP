package br.edu.ifpb.domain.model;

import java.io.Serializable;

import br.edu.ifpb.domain.wrappers.*;

public class RoomType implements Serializable {
    Id typeId;
    RoomDescription description;
    RoomCapacity capacity;

    public RoomType(RoomDescription description, RoomCapacity capacity) {
        this.typeId = new Id();
        this.description = description;
        this.capacity = capacity;
    }

    public Id getRoomTypeId() { return typeId; }
    public RoomDescription getDescription() { return description; }
    public RoomCapacity getCapacity() { return capacity; }

    public void setRoomTypeId(Id typeId) { this.typeId = typeId; }
    public void setDescription(RoomDescription description) { this.description = description; }
    public void setCapacity(RoomCapacity capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* RoomTypeId: ").append(typeId).append("\n");
        sb.append("* Description: ").append(description.getDescription()).append("\n");
        sb.append("* Capacity: ").append(capacity).append("\n");
        sb.append("* Size: ").append(description.getSize()).append("\n");
        return sb.toString();
    }
}
