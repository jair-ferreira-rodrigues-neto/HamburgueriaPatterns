package org.example.comportamental;

public class CaixaHandler extends ReembolsoHandler {
    @Override
    public String processarReembolso(double valor) {
        if (valor <= 20.0) {
            return "Caixa resolveu o reembolso de R$ " + valor;
        } else if (proximo != null) {
            return proximo.processarReembolso(valor);
        }
        return "Reembolso negado";
    }
}