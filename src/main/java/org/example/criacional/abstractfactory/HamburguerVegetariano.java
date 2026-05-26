package org.example.criacional.abstractfactory;

public class HamburguerVegetariano implements LanchePrato {
    @Override
    public String getNomePrato() {
        return "Hambúrguer de Soja";
    }
}