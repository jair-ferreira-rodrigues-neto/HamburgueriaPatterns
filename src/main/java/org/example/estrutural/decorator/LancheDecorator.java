package org.example.estrutural;

import org.example.criacional.factorymethod.Lanche;

public abstract class LancheDecorator implements Lanche {
    protected Lanche lancheOriginal;

    public LancheDecorator(Lanche lanche) {
        this.lancheOriginal = lanche;
    }

    @Override
    public String getDescricao() {
        return lancheOriginal.getDescricao();
    }

    @Override
    public double getPreco() {
        return lancheOriginal.getPreco();
    }
}