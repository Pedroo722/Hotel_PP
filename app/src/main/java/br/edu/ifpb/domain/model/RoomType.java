package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.model.roomtypes.*;
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
    
    protected RoomType(Id roomTypeId, RoomDescription description, RoomCapacity capacity) {
        this.typeId = new Id();
        this.description = description;
        this.capacity = capacity;
    }

    public abstract String getTypeName();

    public Id getRoomTypeId() { return typeId; }
    public RoomDescription getDescription() { return description; }
    public RoomCapacity getCapacity() { return capacity; }

    public static String getSmallRoomCapacity() { return SmallRoomType.getSmallTypeCapacity(); }
    public static String getMediumRoomCapacity() { return MediumRoomType.getMediumTypeCapacity(); }
    public static String getLargeRoomCapacity() { return LargeRoomType.getLargeTypeCapacity(); }
    public static String getDeluxeRoomCapacity() { return DeluxeRoomType.getDeluxeTypeCapacity(); }

    public static String getSmallRoomDescription() { return SmallRoomType.getSmallTypeDescription(); }
    public static String getMediumRoomDescription() { return MediumRoomType.getMediumTypeDescription(); }
    public static String getLargeRoomDescription() { return LargeRoomType.getLargeTypeDescription(); }
    public static String getDeluxeRoomDescription() { return DeluxeRoomType.getDeluxeTypeDescription(); }


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