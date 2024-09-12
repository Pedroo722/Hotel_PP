package br.edu.ifpb.interfaces.strategy;

import br.edu.ifpb.domain.model.*;

public interface PriceStrategy {
    double calculateBasePrice(Reserve Reserve);    
}
