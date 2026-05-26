package org.example;

import org.example.comportamental.chain.CaixaHandler;
import org.example.comportamental.chain.DonoHandler;
import org.example.comportamental.chain.GerenteHandler;
import org.example.comportamental.chain.ReembolsoHandler;
import org.example.comportamental.command.*;
import org.example.comportamental.iterator.Cardapio;
import org.example.comportamental.iterator.ItemIterator;
import org.example.comportamental.mediator.CaixaDriveThru;
import org.example.comportamental.mediator.CoordenadorMediator;
import org.example.comportamental.mediator.CozinheiroDriveThru;
import org.example.comportamental.mediator.Funcionario;
import org.example.comportamental.memento.CarrinhoApp;
import org.example.comportamental.memento.CarrinhoCaretaker;
import org.example.comportamental.observer.MonitorSalao;
import org.example.comportamental.observer.PainelDeSenhas;
import org.example.comportamental.state.OrdemDePreparo;
import org.example.comportamental.strategy.BalcaoStrategy;
import org.example.comportamental.strategy.DeliveryStrategy;
import org.example.comportamental.strategy.EntregaStrategy;
import org.example.comportamental.templatemethod.PreparoCarneTradicional;
import org.example.comportamental.templatemethod.PreparoTemplate;
import org.example.comportamental.templatemethod.PreparoVegano;
import org.example.comportamental.visitor.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComportamentalTest {

    @Test
    public void testStrategyDeEntrega() {
        double valorLanche = 50.0;

        EntregaStrategy appDelivery = new DeliveryStrategy();
        assertEquals(10.00, appDelivery.calcularTaxa(valorLanche));

        EntregaStrategy pegarNoBalcao = new BalcaoStrategy();
        assertEquals(0.0, pegarNoBalcao.calcularTaxa(valorLanche));
    }

    @Test
    public void testStateMaquinaDeEstadosDoPedido() {
        OrdemDePreparo ordem = new OrdemDePreparo(101);
        assertEquals("Na chapa", ordem.getStatus());

        ordem.avancarEstado();
        assertEquals("Aguardando retirada", ordem.getStatus());

        assertThrows(IllegalStateException.class, ordem::avancarEstado);
        assertThrows(IllegalStateException.class, ordem::cancelarPedido);
    }

    @Test
    public void testObserverPainelDeSenhas() {
        PainelDeSenhas painel = new PainelDeSenhas();
        MonitorSalao monitorLobby = new MonitorSalao();

        painel.registrarMonitor(monitorLobby);

        OrdemDePreparo ordem = new OrdemDePreparo(42);

        painel.chamarSenha(ordem);
        assertEquals(0, monitorLobby.getUltimaSenhaChamada());

        ordem.avancarEstado();
        painel.chamarSenha(ordem);
        assertEquals(42, monitorLobby.getUltimaSenhaChamada());
    }

    @Test
    public void testTemplateMethodPreparo() {
        PreparoTemplate carne = new PreparoCarneTradicional();
        String resultadoCarne = carne.prepararLanche();
        assertTrue(resultadoCarne.contains("Hambúrguer bovino grelhado"));
        assertTrue(resultadoCarne.contains("Pão cortado e tostado"));

        PreparoTemplate vegano = new PreparoVegano();
        String resultadoVegano = vegano.prepararLanche();
        assertTrue(resultadoVegano.contains("Hambúrguer de grão de bico"));
        assertTrue(resultadoVegano.contains("Lanche embalado"));
    }

    @Test
    public void testChainOfResponsibilityReembolso() {
        ReembolsoHandler caixa = new CaixaHandler();
        ReembolsoHandler gerente = new GerenteHandler();
        ReembolsoHandler dono = new DonoHandler();

        caixa.setProximo(gerente);
        gerente.setProximo(dono);

        assertEquals("Caixa resolveu o reembolso de R$ 15.0", caixa.processarReembolso(15.0));
        assertEquals("Gerente resolveu o reembolso de R$ 80.0", caixa.processarReembolso(80.0));
        assertEquals("Dono resolveu o reembolso de R$ 250.0", caixa.processarReembolso(250.0));
    }

    @Test
    public void testCommandCozinha() {
        CozinhaReceiver cozinha = new CozinhaReceiver();
        CozinhaCommand pedidoCarne = new AssarCarneCommand(cozinha);
        CozinhaCommand pedidoBatata = new FritarBatataCommand(cozinha);

        ChefeInvoker chefe = new ChefeInvoker();
        chefe.adicionarComando(pedidoCarne);
        chefe.adicionarComando(pedidoBatata);

        assertFalse(cozinha.isChapaOcupada());
        assertFalse(cozinha.isFritadeiraOcupada());

        chefe.executarComandos();

        assertTrue(cozinha.isChapaOcupada());
        assertTrue(cozinha.isFritadeiraOcupada());
    }

    @Test
    public void testMediatorDriveThru() {
        CoordenadorMediator coordenador = new CoordenadorMediator();
        Funcionario caixa = new CaixaDriveThru(coordenador);
        Funcionario cozinheiro = new CozinheiroDriveThru(coordenador);

        coordenador.registrar(caixa);
        coordenador.registrar(cozinheiro);

        caixa.enviar("Novo pedido 501 no Drive-Thru!");

        assertNull(caixa.getUltimaMensagem());
        assertEquals("Novo pedido 501 no Drive-Thru!", cozinheiro.getUltimaMensagem());
    }

    @Test
    public void testIteratorCardapio() {
        Cardapio cardapio = new Cardapio();
        cardapio.adicionarItem("X-Burger");
        cardapio.adicionarItem("Batata Frita");

        ItemIterator iterator = cardapio.criarIterator();

        assertTrue(iterator.temProximo());
        assertEquals("X-Burger", iterator.proximo());
        assertTrue(iterator.temProximo());
        assertEquals("Batata Frita", iterator.proximo());
        assertFalse(iterator.temProximo());
    }

    @Test
    public void testMementoCarrinho() {
        CarrinhoApp carrinho = new CarrinhoApp();
        CarrinhoCaretaker caretaker = new CarrinhoCaretaker();

        carrinho.adicionarItem("Combo 1");
        carrinho.adicionarItem("Suco");
        caretaker.salvarEstado(carrinho.salvar());

        carrinho.limparCarrinho();
        assertEquals(0, carrinho.getItens().size());

        carrinho.restaurar(caretaker.desfazer());
        assertEquals(2, carrinho.getItens().size());
        assertEquals("Suco", carrinho.getItens().get(1));
    }

    @Test
    public void testVisitorImpostos() {
        ProdutoVisitable hamburguer = new ComidaItem(30.0);
        ProdutoVisitable refrigerante = new BebidaItem(10.0);
        ImpostoVisitor calculadora = new CalculadoraImpostoVisitor();

        assertEquals(1.50, hamburguer.aceitar(calculadora));
        assertEquals(1.50, refrigerante.aceitar(calculadora));
    }
}