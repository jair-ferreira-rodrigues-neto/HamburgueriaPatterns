package org.example.criacional;

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