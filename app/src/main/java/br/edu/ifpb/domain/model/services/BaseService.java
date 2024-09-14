package br.edu.ifpb.domain.model.services;

import br.edu.ifpb.interfaces.service.*;

public class BaseService extends ServiceDecorator {

    public BaseService() {
        super(null); 
    }

    @Override
    public double calculateCost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Serviços base";
    }
}
