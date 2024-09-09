package br.edu.ifpb.interfaces.observer;

public interface Observable<T> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
    void notifyObservers();
}
