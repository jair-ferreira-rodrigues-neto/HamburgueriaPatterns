package org.example.comportamental.interpreter;

public class AcumularDescontos implements ExpressaoPromocional {
    private ExpressaoPromocional primeiraRegra;
    private ExpressaoPromocional segundaRegra;

    public AcumularDescontos(ExpressaoPromocional primeiraRegra, ExpressaoPromocional segundaRegra) {
        this.primeiraRegra = primeiraRegra;
        this.segundaRegra = segundaRegra;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        double valorAposPrimeiro = primeiraRegra.aplicarDesconto(valorOriginal);
        return segundaRegra.aplicarDesconto(valorAposPrimeiro);
    }
}