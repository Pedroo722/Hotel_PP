package br.edu.ifpb.interfaces;

public interface AdministradorIF {
    public void atribuirTarefa();

    public void consultarTerafas();

    public void removerTarefa();
    
    public void consultarHospedesAtivos(); // Método para obter uma lista de hóspedes que estão atualmente hospedados no hotel.    

    public void consultarFuncionarios();

    public void consultarClientes();
}
