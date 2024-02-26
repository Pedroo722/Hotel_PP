package br.edu.ifpb.interfaces;

public interface AutenticationIF {
    public static void login(String username, String password) {};
    
    public static boolean validateUser(String username, String password) {};
}