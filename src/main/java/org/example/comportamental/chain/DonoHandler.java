package org.example.comportamental.chain;

public class DonoHandler extends ReembolsoHandler {
    @Override
    public String processarReembolso(double valor) {
        return "Dono resolveu o reembolso de R$ " + valor;
    }
}