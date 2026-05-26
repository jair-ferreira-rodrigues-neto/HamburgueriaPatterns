package org.example.comportamental;

public class BebidaItem implements ProdutoVisitable {
    private double preco;

    public BebidaItem(double preco) {
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