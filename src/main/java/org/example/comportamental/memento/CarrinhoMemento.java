package org.example.comportamental;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoMemento {
    private final List<String> itensSalvos;

    public CarrinhoMemento(List<String> itens) {
        this.itensSalvos = new ArrayList<>(itens);
    }

    public List<String> getItensSalvos() {
        return itensSalvos;
    }
}