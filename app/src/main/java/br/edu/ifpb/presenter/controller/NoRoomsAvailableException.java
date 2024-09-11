package br.edu.ifpb.presenter.controller;

public class NoRoomsAvailableException extends Exception {
    public NoRoomsAvailableException(String message) {
        super(message);
    }
}
