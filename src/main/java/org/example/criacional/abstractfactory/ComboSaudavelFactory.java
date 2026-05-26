package org.example.criacional.abstractfactory;

public class ComboSaudavelFactory implements ComboFactory {
    @Override
    public LanchePrato criarLanche() {
        return new HamburguerVegetariano();
    }

    @Override
    public BebidaPrato criarBebida() {
        return new SucoNatural();
    }
}