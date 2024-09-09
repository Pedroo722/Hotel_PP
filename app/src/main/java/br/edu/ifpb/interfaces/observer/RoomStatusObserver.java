package br.edu.ifpb.interfaces.observer;

import br.edu.ifpb.domain.model.Room;

public class RoomStatusObserver implements Observer<Room> {
    @Override
    public void update(Room room) {
        System.out.println("O status do quarto foi atualizado: " + room);
    }
}
