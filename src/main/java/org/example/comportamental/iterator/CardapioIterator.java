package org.example.comportamental;

import java.util.List;

public class CardapioIterator implements ItemIterator {
    private List<String> itens;
    private int posicao = 0;

    public CardapioIterator(List<String> itens) {
        this.itens = itens;
    }

    @Override
    public boolean temProximo() {
        return posicao < itens.size();
    }

    @Override
    public String proximo() {
        if (this.temProximo()) {
            String item = itens.get(posicao);
            posicao++;
            return item;
        }
        return null;
    }
}