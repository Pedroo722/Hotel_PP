package br.edu.ifpb.domain.model.roomtypes;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

// Padrão de Criação: Factory
public class DeluxeRoomType extends RoomType {
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