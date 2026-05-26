package org.example.comportamental;

public class GerenteHandler extends ReembolsoHandler {
    @Override
    public String processarReembolso(double valor) {
        if (valor <= 100.0) {
            return "Gerente resolveu o reembolso de R$ " + valor;
        } else if (proximo != null) {
            return proximo.processarReembolso(valor);
        }
        return "Reembolso negado";
    }
}