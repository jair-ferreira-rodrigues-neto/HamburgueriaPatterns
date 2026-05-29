package org.example;

import org.example.criacional.factorymethod.Lanche;
import org.example.criacional.factorymethod.LancheFactory;
import org.example.estrutural.bridge.*;
import org.example.estrutural.composite.CaixaCombo;
import org.example.estrutural.composite.ItemComercial;
import org.example.estrutural.composite.ProdutoAvulso;
import org.example.estrutural.decorator.AdicionalBacon;
import org.example.estrutural.flyweight.NutricaoFactory;
import org.example.estrutural.flyweight.TabelaNutricional;
import org.example.estrutural.adapter.*;
import org.example.estrutural.proxy.*;
import org.example.criacional.singleton.FilaDePedidos;
import org.example.criacional.builder.Pedido;
import org.example.estrutural.facade.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstruturalTest {

    @Test
    public void testDecoratorECompositeEFlyweight() {
        LancheFactory chapa = new LancheFactory();
        Lanche lancheBase = chapa.criarLanche("XBURGER");
        Lanche lancheComBacon = new AdicionalBacon(lancheBase);

        assertEquals(30.00, lancheComBacon.getPreco());
        assertEquals("X-Burger Tradicional + Adicional de Bacon", lancheComBacon.getDescricao());

        ItemComercial refri = new ProdutoAvulso("Refrigerante", 8.00);
        ItemComercial batata = new ProdutoAvulso("Batata Frita", 12.00);
        ItemComercial hamburguerPromo = new ProdutoAvulso("X-Burger", 25.00);

        CaixaCombo comboFamilia = new CaixaCombo("Super Combo Especial");
        comboFamilia.adicionarItem(refri);
        comboFamilia.adicionarItem(batata);
        comboFamilia.adicionarItem(hamburguerPromo);

        assertEquals(40.50, comboFamilia.getValor(), 0.01);
        assertEquals("Super Combo Especial (Combo com 3 itens)", comboFamilia.getNome());

        TabelaNutricional tab1 = NutricaoFactory.getTabela("XBURGER");
        TabelaNutricional tab2 = NutricaoFactory.getTabela("XBURGER");

        assertSame(tab1, tab2);
    }

    @Test
    public void testBridgePagamento() {
        ProcessadorBridge cielo = new CieloProcessador();
        Pagamento cartao = new CartaoPagamento(cielo);
        assertEquals("Pago no cartão: 55.0", cartao.realizarPagamento(55.0));

        ProcessadorBridge mercadoPago = new MercadoPagoProcessador();
        Pagamento pix = new PixPagamento(mercadoPago);
        assertEquals("Pago no PIX: 30.0", pix.realizarPagamento(30.0));
    }

    @Test
    public void testAdapterDeliveryExterno() {
        FilaDePedidos.getInstancia().getPedidos().clear();

        ServicoDeliveryExterno apiAntiga = new ServicoDeliveryExterno();
        ImportadorPedido adaptador = new DeliveryAdapter(apiAntiga);

        adaptador.importarPedidoExterno();

        assertEquals(1, FilaDePedidos.getInstancia().getPedidos().size());
        Pedido pedidoImportado = FilaDePedidos.getInstancia().getPedidos().get(0);

        assertEquals("X-Burger Tradicional", pedidoImportado.getLanche().getDescricao());
        assertEquals("Cola", pedidoImportado.getBebida());
        assertEquals("Batata", pedidoImportado.getAcompanhamento());
    }

    @Test
    public void testProxyRelatorioFaturamento() {
        RelatorioHamburgueria proxyGerente = new ProxyRelatorio("GERENTE");
        assertEquals("Faturamento do dia: R$ 5.430,00", proxyGerente.gerarRelatorioDiario());

        RelatorioHamburgueria proxyCaixa = new ProxyRelatorio("CAIXA");
        assertEquals("Acesso Negado: Apenas gerentes podem ver o faturamento.", proxyCaixa.gerarRelatorioDiario());
    }

    @Test
    public void testFechamentoLojaFacade() {
        FechamentoLojaFacade fechamento = new FechamentoLojaFacade();
        String resultado = fechamento.encerrarExpediente();
        assertEquals("Painel desligado. Chapa esfriando. Portas trancadas e alarme ativado.", resultado);
    }
}