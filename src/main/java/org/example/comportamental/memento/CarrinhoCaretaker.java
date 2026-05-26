package org.example.comportamental;

import java.util.Stack;

public class CarrinhoCaretaker {
    private Stack<CarrinhoMemento> historico = new Stack<>();

    public void salvarEstado(CarrinhoMemento memento) {
        historico.push(memento);
    }

    public CarrinhoMemento desfazer() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }
}