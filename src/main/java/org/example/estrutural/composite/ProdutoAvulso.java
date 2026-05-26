package org.example.estrutural.composite;

public class ProdutoAvulso implements ItemComercial {
    private String nome;
    private double valor;

    public ProdutoAvulso(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getNome() {
        return nome;
    }
}