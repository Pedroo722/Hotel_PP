package br.edu.ifpb.presenter.controller;

public class NoReservesAvailableException extends Exception {
    public NoReservesAvailableException(String message) {
        super(message);
    }
}