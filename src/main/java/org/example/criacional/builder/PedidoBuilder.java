package org.example.criacional.builder;

import org.example.criacional.factorymethod.Lanche;

public class PedidoBuilder {
    private Lanche lanche;
    private String bebida;
    private String acompanhamento;

    public PedidoBuilder adicionarLanche(Lanche lanche) {
        this.lanche = lanche;
        return this;
    }

    public PedidoBuilder adicionarBebida(String bebida) {
        this.bebida = bebida;
        return this;
    }

    public PedidoBuilder adicionarAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
        return this;
    }

    public Pedido construir() {
        return new Pedido(lanche, bebida, acompanhamento);
    }
}