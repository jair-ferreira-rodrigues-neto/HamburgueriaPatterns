package org.example.estrutural;

import java.util.HashMap;
import java.util.Map;

public class NutricaoFactory {
    private static Map<String, TabelaNutricional> cache = new HashMap<>();

    public static TabelaNutricional getTabela(String tipoDoLanche) {
        if (!cache.containsKey(tipoDoLanche)) {
            if (tipoDoLanche.equalsIgnoreCase("XBURGER")) {
                cache.put(tipoDoLanche, new TabelaNutricional("500 kcal", "Contém Glúten e Lactose"));
            } else if (tipoDoLanche.equalsIgnoreCase("VEGANO")) {
                cache.put(tipoDoLanche, new TabelaNutricional("350 kcal", "Não contém Glúten"));
            }
        }
        return cache.get(tipoDoLanche);
    }
}