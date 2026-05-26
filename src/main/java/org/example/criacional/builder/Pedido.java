package org.example.criacional.builder;

import org.example.criacional.factorymethod.Lanche;

public class Pedido {
    private Lanche lanche;
    private String bebida;
    private String acompanhamento;

    public Pedido(Lanche lanche, String bebida, String acompanhamento) {
        this.lanche = lanche;
        this.bebida = bebida;
        this.acompanhamento = acompanhamento;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public String getBebida() {
        return bebida;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }
}