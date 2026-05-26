package org.example.comportamental;

public interface ImpostoVisitor {
    double visitar(ComidaItem comida);
    double visitar(BebidaItem bebida);
}