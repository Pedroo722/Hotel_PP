package br.edu.ifpb.domain.model.roomtypes;

import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

// Padrão de Criação: Factory
public class SmallRoomType extends RoomType {
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