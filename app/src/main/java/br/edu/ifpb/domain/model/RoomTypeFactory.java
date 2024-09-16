package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.model.roomtypes.*;

// Padrão de Criação: Factory
public class RoomTypeFactory {
    public static RoomType createRoomType(String type) {
        switch (type) {
            case "Single":
                return new SmallRoomType();
            case "Double":
                return new MediumRoomType();
            case "Large":
                return new LargeRoomType();
            case "Deluxe":
                return new DeluxeRoomType();
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }
}