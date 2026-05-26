package org.example.criacional.singleton;

import org.example.criacional.builder.Pedido;

import java.util.ArrayList;
import java.util.List;

public class FilaDePedidos {
    private static FilaDePedidos instancia;
    private List<Pedido> pedidos;

    private FilaDePedidos() {
        pedidos = new ArrayList<>();
    }

    public static synchronized FilaDePedidos getInstancia() {
        if (instancia == null) {
            instancia = new FilaDePedidos();
        }
        return instancia;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}