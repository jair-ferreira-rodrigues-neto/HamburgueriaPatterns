package org.example.comportamental.visitor;

public interface ProdutoVisitable {
    double aceitar(ImpostoVisitor visitor);
}