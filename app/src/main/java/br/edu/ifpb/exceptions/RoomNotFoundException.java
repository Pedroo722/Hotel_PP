package br.edu.ifpb.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException() {
        super("Quarto não encontrado!");
    }   
}
