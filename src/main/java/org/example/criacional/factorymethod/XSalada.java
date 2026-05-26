package org.example.criacional;

public class XSalada implements Lanche {
    @Override
    public String getDescricao() {
        return "X-Salada com Maionese da Casa";
    }

    @Override
    public double getPreco() {
        return 28.0;
    }
}