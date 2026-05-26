package org.example.estrutural;

import java.util.ArrayList;
import java.util.List;

public class CaixaCombo implements ItemComercial {
    private String nomeDoCombo;
    private List<ItemComercial> itens = new ArrayList<>();

    public CaixaCombo(String nomeDoCombo) {
        this.nomeDoCombo = nomeDoCombo;
    }

    public void adicionarItem(ItemComercial item) {
        itens.add(item);
    }

    @Override
    public double getValor() {
        double total = 0;
        for (ItemComercial item : itens) {
            total += item.getValor();
        }
        return total * 0.90;
    }

    @Override
    public String getNome() {
        return nomeDoCombo + " (Combo com " + itens.size() + " itens)";
    }
}