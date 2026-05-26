package org.example.comportamental;

public class PreparoCarneTradicional extends PreparoTemplate {
    @Override
    protected String prepararProteina() {
        return "Hambúrguer bovino grelhado ao ponto";
    }

    @Override
    protected String adicionarAcompanhamentos() {
        return "Queijo prato e alface";
    }
}