package org.example.estrutural.adapter;

import org.example.criacional.builder.PedidoBuilder;
import org.example.criacional.factorymethod.LancheFactory;
import org.example.criacional.singleton.FilaDePedidos;
import org.example.criacional.builder.Pedido;
import org.example.criacional.factorymethod.Lanche;

public class DeliveryAdapter implements ImportadorPedido {
    private ServicoDeliveryExterno servicoExterno;
    private LancheFactory chapa;

    public DeliveryAdapter(ServicoDeliveryExterno servicoExterno) {
        this.servicoExterno = servicoExterno;
        this.chapa = new LancheFactory();
    }

    @Override
    public void importarPedidoExterno() {
        String dadosBrutos = servicoExterno.buscarPedidoApp();

        String[] partes = dadosBrutos.split("\\|");
        String tipoLanche = partes[0].split(":")[1];
        String bebida = partes[1].split(":")[1];
        String extra = partes[2].split(":")[1];

        Lanche lancheAdaptado = chapa.criarLanche(tipoLanche);
        Pedido novoPedido = new PedidoBuilder()
                .adicionarLanche(lancheAdaptado)
                .adicionarBebida(bebida)
                .adicionarAcompanhamento(extra)
                .construir();

        FilaDePedidos.getInstancia().adicionarPedido(novoPedido);
    }
}