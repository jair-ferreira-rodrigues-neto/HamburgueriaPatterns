package org.example.comportamental;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoApp {
    private List<String> itens = new ArrayList<>();

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public List<String> getItens() {
        return itens;
    }

    public CarrinhoMemento salvar() {
        return new CarrinhoMemento(this.itens);
    }

    public void restaurar(CarrinhoMemento memento) {
        this.itens = new ArrayList<>(memento.getItensSalvos());
    }
}