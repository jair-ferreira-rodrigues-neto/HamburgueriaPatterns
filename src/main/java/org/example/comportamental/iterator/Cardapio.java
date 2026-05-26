package org.example.comportamental;

import java.util.ArrayList;
import java.util.List;

public class Cardapio implements ColecaoCardapio {
    private List<String> itens = new ArrayList<>();

    public void adicionarItem(String item) {
        itens.add(item);
    }

    @Override
    public ItemIterator criarIterator() {
        return new CardapioIterator(this.itens);
    }
}