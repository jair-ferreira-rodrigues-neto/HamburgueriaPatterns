package org.example.estrutural.proxy;

public class ProxyRelatorio implements RelatorioHamburgueria {
    private RelatorioReal relatorioReal;
    private String cargoFuncionario;

    public ProxyRelatorio(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    @Override
    public String gerarRelatorioDiario() {
        if ("GERENTE".equals(cargoFuncionario)) {
            if (relatorioReal == null) {
                relatorioReal = new RelatorioReal();
            }
            return relatorioReal.gerarRelatorioDiario();
        }
        return "Acesso Negado: Apenas gerentes podem ver o faturamento.";
    }
}