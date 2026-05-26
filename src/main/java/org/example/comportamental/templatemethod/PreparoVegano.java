package org.example.comportamental;

public class PreparoVegano extends PreparoTemplate {
    @Override
    protected String prepararProteina() {
        return "Hambúrguer de grão de bico assado";
    }

    @Override
    protected String adicionarAcompanhamentos() {
        return "Creme de castanhas e rúcula";
    }
}