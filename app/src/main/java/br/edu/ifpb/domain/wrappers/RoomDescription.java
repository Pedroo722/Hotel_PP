package br.edu.ifpb.domain.wrappers;


public enum RoomDescription {
    SMALL("Small room for a single person", "Small"),
    MEDIUM("Twin room for 2 people", "Medium"),
    LARGE("Large room for a entire family", "Large"),
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
