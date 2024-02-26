package br.edu.ifpb.model;

import br.edu.ifpb.interfaces.AutenticationIF;
import br.edu.ifpb.validators.StringValidator;

public class Autentication implements AutenticationIF {
    public static void login(String username, String password) {
        if (validateUser(username, password)) {
            // resto da logica
        };
    };

    public static boolean validateUser(String username, String password) {
        boolean isNameValid = new StringValidator().validate(username);
        boolean isPasswordValid = new StringValidator().validate(password);

        if (isNameValid && isPasswordValid) {
            return true;
        }

        return false;
    };
}
