package org.example.comportamental;

public class DeliveryStrategy implements EntregaStrategy {
    @Override
    public double calcularTaxa(double valorPedido) {
        return valorPedido * 0.10 + 5.00;
    }
}