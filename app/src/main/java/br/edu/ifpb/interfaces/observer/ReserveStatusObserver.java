package br.edu.ifpb.interfaces.observer;

import br.edu.ifpb.domain.model.Reserve;

public class ReserveStatusObserver implements Observer<Reserve> {
    @Override
    public void update(Reserve reserve) {
        System.out.println("O status da reserva foi atualizada: " + reserve);
    }
}
