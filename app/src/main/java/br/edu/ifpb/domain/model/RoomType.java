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

// Classes usadas pela RoomTypeFactory
class SmallRoomType extends RoomType {
    public SmallRoomType() {
        super(RoomDescription.SMALL, new RoomCapacity(1));
    }

    @Override
    public String getTypeName() {
        return "Small room for a single person";
    }

    public static String getSmallTypeDescription() {
        return "Quarto pequeno para uma única pessoa.";
    }

    public static String getSmallTypeCapacity() {
        return "1";
    }
}

class MediumRoomType extends RoomType {
    public MediumRoomType() {
        super(RoomDescription.MEDIUM, new RoomCapacity(2));
    }

    @Override
    public String getTypeName() {
        return "Twin room for 2 people";
    }

    public static String getMediumTypeDescription() {
        return "Quarto duplo para 2 pessoas";
    }

    public static String getMediumTypeCapacity() {
        return "2";
    }
}

class LargeRoomType extends RoomType {
    public LargeRoomType() {
        super(RoomDescription.LARGE, new RoomCapacity(4));
    }

    @Override
    public String getTypeName() {
        return "Large room for a entire family";
    }

    public static String getLargeTypeDescription() {
        return "Quarto grande para uma família inteira";
    }

    public static String getLargeTypeCapacity() {
        return "4";
    }
}

class DeluxeRoomType extends RoomType {
    public DeluxeRoomType() {
        super(RoomDescription.LUXURY, new RoomCapacity(2));
    }

    @Override
    public String getTypeName() {
        return "Deluxe Room";
    }

    
    public static String getDeluxeTypeDescription() {
        return "Quarto de luxo com serviços premium para até 2 pessoas";
    }

    public static String getDeluxeTypeCapacity() {
        return "8";
    }
}