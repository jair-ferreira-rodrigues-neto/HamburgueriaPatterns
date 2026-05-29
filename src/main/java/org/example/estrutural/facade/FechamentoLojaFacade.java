package org.example.estrutural.facade;

public class FechamentoLojaFacade {
    private SistemaIluminacao iluminacao;
    private EquipamentoChapa chapa;
    private SistemaSeguranca seguranca;

    public FechamentoLojaFacade() {
        this.iluminacao = new SistemaIluminacao();
        this.chapa = new EquipamentoChapa();
        this.seguranca = new SistemaSeguranca();
    }

    public String encerrarExpediente() {
        return iluminacao.desligarPainel() + " " + chapa.esfriar() + " " + seguranca.trancar();
    }
}