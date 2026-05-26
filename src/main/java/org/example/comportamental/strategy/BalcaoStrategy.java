package org.example.comportamental;

public class BalcaoStrategy implements EntregaStrategy {
    @Override
    public double calcularTaxa(double valorPedido) {
        return 0.0;
    }
}