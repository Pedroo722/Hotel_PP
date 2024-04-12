package br.edu.ifpb.exceptions;

public class InvalidRoomNumberException extends RuntimeException {
    public InvalidRoomNumberException() {
        super("Número de quarto inválido");
    }
}
