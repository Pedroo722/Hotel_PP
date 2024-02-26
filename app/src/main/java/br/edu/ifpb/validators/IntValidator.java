package br.edu.ifpb.validators;

public class IntValidator implements Validator<Integer> {
    @Override
    public boolean validate(Integer value) {
        return value != null && value > 0;
    }
}