package org.example.comportamental.visitor;

public class ComidaItem implements ProdutoVisitable {
    private double preco;

    public ComidaItem(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public double aceitar(ImpostoVisitor visitor) {
        return visitor.visitar(this);
    }
}