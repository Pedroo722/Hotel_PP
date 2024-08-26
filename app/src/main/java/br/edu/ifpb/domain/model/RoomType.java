package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;

public abstract class RoomType {
    protected Id typeId;
    protected RoomDescription description;
    protected RoomCapacity capacity;

    protected RoomType(RoomDescription description, RoomCapacity capacity) {
        this.typeId = new Id();
        this.description = description;
        this.capacity = capacity;
    }

    public abstract String getTypeName();

    public Id getRoomTypeId() { return typeId; }
    public RoomDescription getDescription() { return description; }
    public RoomCapacity getCapacity() { return capacity; }

    public static RoomType getRoomTypeFromId(int typeId) {
        switch (typeId) {
            case 1:
                return new SmallRoomType();
            case 2: 
                return new MediumRoomType();
            case 3: 
                return new LargeRoomType();
            case 4: 
                return new DeluxeRoomType();
            default:
                throw new IllegalArgumentException("Invalid room type ID: " + typeId);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("* Type: ").append(getTypeName()).append("\n");
        sb.append("* Description: ").append(description.getDescription()).append("\n");
        sb.append("* Capacity: ").append(capacity).append("\n");
        sb.append("* Size: ").append(description.getSize()).append("\n");
        return sb.toString();
    }
}

// Classes usadas pela RoomTypeFactory
class SmallRoomType extends RoomType {
    public SmallRoomType() {
        super(RoomDescription.SMALL, new RoomCapacity(1));
    }

    @Override
    public String getTypeName() {
        return "Small-sized Room";
    }
}

class MediumRoomType extends RoomType {
    public MediumRoomType() {
        super(RoomDescription.MEDIUM, new RoomCapacity(2));
    }

    @Override
    public String getTypeName() {
        return "Medium-sized Room";
    }
}

class LargeRoomType extends RoomType {
    public LargeRoomType() {
        super(RoomDescription.LARGE, new RoomCapacity(4));
    }

    @Override
    public String getTypeName() {
        return "Large-sized Room";
    }
}

class DeluxeRoomType extends RoomType {
    public DeluxeRoomType() {
        super(RoomDescription.LUXURY, new RoomCapacity(8));
    }

    @Override
    public String getTypeName() {
        return "Deluxe Room";
    }
}