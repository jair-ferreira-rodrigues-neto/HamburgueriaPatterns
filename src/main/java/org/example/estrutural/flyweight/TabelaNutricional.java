package org.example.estrutural.flyweight;

public class TabelaNutricional {
    private String calorias;
    private String alergicos;

    public TabelaNutricional(String calorias, String alergicos) {
        this.calorias = calorias;
        this.alergicos = alergicos;
    }

    public String getInformacoes() {
        return "Calorias: " + calorias + " | Alérgicos: " + alergicos;
    }
}