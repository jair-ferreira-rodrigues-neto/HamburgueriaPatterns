package org.example.estrutural.proxy;

public class RelatorioReal implements RelatorioHamburgueria {
    @Override
    public String gerarRelatorioDiario() {
        return "Faturamento do dia: R$ 5.430,00";
    }
}