package br.edu.ifpb.domain.model.roomtypes;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

// Padrão de Criação: Factory
public class LargeRoomType extends RoomType {
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
