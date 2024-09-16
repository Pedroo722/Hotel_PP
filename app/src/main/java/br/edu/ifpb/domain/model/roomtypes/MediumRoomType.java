package br.edu.ifpb.domain.model.roomtypes;


import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;

// Padrão de Criação: Factory
public class MediumRoomType extends RoomType {
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
