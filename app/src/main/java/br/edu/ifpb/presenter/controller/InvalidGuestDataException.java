package br.edu.ifpb.presenter.controller;

public class InvalidGuestDataException extends RuntimeException {
    public InvalidGuestDataException(String message) {
        super(message);
    }
}
