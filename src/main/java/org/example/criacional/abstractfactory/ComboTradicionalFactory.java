package org.example.criacional;

public class ComboTradicionalFactory implements ComboFactory {
    @Override
    public LanchePrato criarLanche() {
        return new HamburguerBovino();
    }

    @Override
    public BebidaPrato criarBebida() {
        return new RefrigeranteCola();
    }
}