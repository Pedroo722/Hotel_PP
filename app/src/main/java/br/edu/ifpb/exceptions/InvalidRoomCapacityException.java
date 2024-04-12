package br.edu.ifpb.exceptions;

public class InvalidRoomCapacityException extends RuntimeException {
    public InvalidRoomCapacityException() {
        super("Valor da capacidade de quarto inválido");
    }
}
