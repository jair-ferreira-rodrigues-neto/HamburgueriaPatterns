package org.example.estrutural;

public abstract class Pagamento {
    protected ProcessadorBridge processador;

    public Pagamento(ProcessadorBridge processador) {
        this.processador = processador;
    }

    public abstract String realizarPagamento(double valor);
}