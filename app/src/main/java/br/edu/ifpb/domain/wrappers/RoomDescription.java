package br.edu.ifpb.domain.wrappers;


public enum RoomDescription {
    SMALL("Small room for few people", "Small"),
    MEDIUM("Medium room for average family", "Medium"),
    LARGE("Large room for large gathering of people", "Large"),
    LUXURY("Deluxe room for premium services", "Luxury");

    private final String description;
    private final String size;

    RoomDescription(String description, String size) {
        this.description = description;
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }
}
