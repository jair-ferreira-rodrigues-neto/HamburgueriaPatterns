package org.example.criacional.factorymethod;

public class LancheFactory {
    public Lanche criarLanche(String tipo) {
        if (tipo.equalsIgnoreCase("XBURGER")) {
            return new XBurger();
        } else if (tipo.equalsIgnoreCase("XSALADA")) {
            return new XSalada();
        }
        throw new IllegalArgumentException("Lanche não existe no cardápio");
    }
}