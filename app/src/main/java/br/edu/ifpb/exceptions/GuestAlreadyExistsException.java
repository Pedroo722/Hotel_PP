package br.edu.ifpb.exceptions;

public class GuestAlreadyExistsException extends RuntimeException {
    public GuestAlreadyExistsException() {
        super("Hóspede com este CPF já foi cadastrado no sistema!");
    }   
}
