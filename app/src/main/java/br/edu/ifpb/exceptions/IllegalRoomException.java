package br.edu.ifpb.exceptions;

public class IllegalRoomException extends IllegalArgumentException {
    public IllegalRoomException() {
        super("Todos os atributos de Room devem ser preenchidos!");
    }
}
