package org.example.comportamental.interpreter;

public class DescontoPercentual implements ExpressaoPromocional {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - (valorOriginal * (percentual / 100));
    }
}