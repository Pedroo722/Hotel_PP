package br.edu.ifpb.interfaces;

import java.util.List;

public interface AdministratorIF {
    public void assignTask();

    public List<Integer> consultTasks();

    public void removeTask();

    public List<Integer> consultGuestList();

    public List<Integer> consultActiveGuest(); // Método para obter uma lista de hóspedes que estão atualmente hospedados no hotel.    

    public List<Integer> consultEmployees();

}
