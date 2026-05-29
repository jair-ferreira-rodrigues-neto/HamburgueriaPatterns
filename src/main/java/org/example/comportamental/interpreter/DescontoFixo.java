package org.example.comportamental.interpreter;

public class DescontoFixo implements ExpressaoPromocional {
    private double valorDesconto;

    public DescontoFixo(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - valorDesconto;
    }
}