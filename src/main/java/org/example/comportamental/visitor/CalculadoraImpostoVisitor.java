package org.example.comportamental.visitor;

public class CalculadoraImpostoVisitor implements ImpostoVisitor {
    @Override
    public double visitar(ComidaItem comida) {
        return comida.getPreco() * 0.05;
    }

    @Override
    public double visitar(BebidaItem bebida) {
        return bebida.getPreco() * 0.15;
    }
}