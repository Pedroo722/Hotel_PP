package br.edu.ifpb.interfaces.observer;

public interface Observer<T> {
    void update(T subject);
}