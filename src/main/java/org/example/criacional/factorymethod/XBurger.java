package org.example.criacional.factorymethod;

public class XBurger implements Lanche {
    @Override
    public String getDescricao() {
        return "X-Burger Tradicional";
    }

    @Override
    public double getPreco() {
        return 25.0;
    }
}