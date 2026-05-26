package org.example.comportamental.visitor;

public interface ImpostoVisitor {
    double visitar(ComidaItem comida);
    double visitar(BebidaItem bebida);
}