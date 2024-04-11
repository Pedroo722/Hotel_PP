package br.edu.ifpb.menu;

import br.edu.ifpb.data.RoomTypeRepository;
import br.edu.ifpb.domain.model.RoomType;
import br.edu.ifpb.domain.wrappers.RoomCapacity;
import br.edu.ifpb.domain.wrappers.RoomDescription;

import java.util.ArrayList;
import java.util.List;

public class CreateRoomTypes {
    private List<RoomType> roomTypes = new ArrayList<>();

    public static void main(String[] args) {
        CreateRoomTypes createRoomTypes = new CreateRoomTypes();

        // Criando instâncias de RoomType para cada tipo de quarto
        RoomType smallRoom = new RoomType(RoomDescription.SMALL, new RoomCapacity(2));
        RoomType mediumRoom = new RoomType(RoomDescription.MEDIUM, new RoomCapacity(4));
        RoomType largeRoom = new RoomType(RoomDescription.LARGE, new RoomCapacity(6));
        RoomType luxuryRoom = new RoomType(RoomDescription.LUXURY, new RoomCapacity(8));

        // Adicionando os tipos de quartos à lista de tipos de quartos
        createRoomTypes.addRoomType(smallRoom);
        createRoomTypes.addRoomType(mediumRoom);
        createRoomTypes.addRoomType(largeRoom);
        createRoomTypes.addRoomType(luxuryRoom);

        // Salvando os tipos de quartos na classe RoomTypeRepository
        RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();
        for (RoomType roomType : createRoomTypes.getRoomTypes()) {
            roomTypeRepository.addRoom(roomType);
        }
        roomTypeRepository.saveRoomTypesToFile();

        // Exibindo os tipos de quartos criados
        createRoomTypes.displayRoomTypes();
    }

    public void addRoomType(RoomType roomType) {
        roomTypes.add(roomType);
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void displayRoomTypes() {
        for (RoomType roomType : roomTypes) {
            System.out.println(roomType);
        }
    }
}
