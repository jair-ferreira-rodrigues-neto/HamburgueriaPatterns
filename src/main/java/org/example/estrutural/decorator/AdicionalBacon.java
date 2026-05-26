package org.example.estrutural.decorator;

import org.example.criacional.factorymethod.Lanche;

public class AdicionalBacon extends LancheDecorator {
    public AdicionalBacon(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return lancheOriginal.getDescricao() + " + Adicional de Bacon";
    }

    @Override
    public double getPreco() {
        return lancheOriginal.getPreco() + 5.00;
    }
}