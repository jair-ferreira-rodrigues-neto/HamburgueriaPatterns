package org.example;

import org.example.criacional.abstractfactory.ComboFactory;
import org.example.criacional.abstractfactory.ComboSaudavelFactory;
import org.example.criacional.abstractfactory.ComboTradicionalFactory;
import org.example.criacional.builder.Pedido;
import org.example.criacional.builder.PedidoBuilder;
import org.example.criacional.factorymethod.Lanche;
import org.example.criacional.factorymethod.LancheFactory;
import org.example.criacional.prototype.CupomSorteio;
import org.example.criacional.singleton.FilaDePedidos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriacionalTest {

    @Test
    public void testFactoryMethodEBuilderESingleton() {
        LancheFactory chapa = new LancheFactory();
        Lanche meuLanche = chapa.criarLanche("XBURGER");

        Pedido meuCombo = new PedidoBuilder()
                .adicionarLanche(meuLanche)
                .adicionarBebida("Refrigerante Cola")
                .adicionarAcompanhamento("Batata Frita Média")
                .construir();

        FilaDePedidos fila = FilaDePedidos.getInstancia();
        fila.adicionarPedido(meuCombo);

        assertEquals("X-Burger Tradicional", meuCombo.getLanche().getDescricao());
        assertEquals("Refrigerante Cola", meuCombo.getBebida());

        FilaDePedidos mesmaFila = FilaDePedidos.getInstancia();
        assertEquals(1, mesmaFila.getPedidos().size());
        assertSame(fila, mesmaFila);
    }

    @Test
    public void testAbstractFactoryCombo() {
        ComboFactory tradicional = new ComboTradicionalFactory();
        assertEquals("Hambúrguer Bovino", tradicional.criarLanche().getNomePrato());
        assertEquals("Refrigerante de Cola", tradicional.criarBebida().getNomeBebida());

        ComboFactory saudavel = new ComboSaudavelFactory();
        assertEquals("Hambúrguer de Soja", saudavel.criarLanche().getNomePrato());
        assertEquals("Suco de Laranja", saudavel.criarBebida().getNomeBebida());
    }

    @Test
    public void testClonagemCupomSorteio() {
        CupomSorteio cupomBase = new CupomSorteio("Sorteio de 1 Ano de Hamburguer.");

        CupomSorteio cupomCliente1 = cupomBase.clone();
        cupomCliente1.setCpfCliente("111.222.333-44");

        CupomSorteio cupomCliente2 = cupomBase.clone();
        cupomCliente2.setCpfCliente("555.666.777-88");

        assertNotSame(cupomBase, cupomCliente1);
        assertEquals("Regras: Sorteio de 1 Ano de Hamburguer. | Participante: 111.222.333-44", cupomCliente1.getDetalhes());
        assertEquals("Regras: Sorteio de 1 Ano de Hamburguer. | Participante: 555.666.777-88", cupomCliente2.getDetalhes());
    }
}