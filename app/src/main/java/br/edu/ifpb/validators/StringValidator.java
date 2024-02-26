package br.edu.ifpb.validators;

public class StringValidator implements Validator<String> {
    @Override
    public boolean validate(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
