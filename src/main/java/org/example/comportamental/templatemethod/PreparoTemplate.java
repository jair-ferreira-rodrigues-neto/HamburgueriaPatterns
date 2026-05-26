package org.example.comportamental;

public abstract class PreparoTemplate {

    public final String prepararLanche() {
        return separarPao() + " | " +
                prepararProteina() + " | " +
                adicionarAcompanhamentos() + " | " +
                embalar();
    }

    private String separarPao() {
        return "Pão cortado e tostado";
    }

    private String embalar() {
        return "Lanche embalado na caixa padrão";
    }

    protected abstract String prepararProteina();

    protected abstract String adicionarAcompanhamentos();
}