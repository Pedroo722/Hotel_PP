package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.AutenticationIF;

public class Autentication implements AutenticationIF {
    public static void login(String username, String password) {
        if (validateUser(username, password)) {
            // resto da logica
        };
    };

    public static boolean validateUser(String username, String password) {
        // fazer validators

        return true;
    };
}
