package org.example.comportamental.observer;

public class MonitorSalao implements PedidoObserver {
    private int ultimaSenhaChamada;

    @Override
    public void atualizar(int numeroFicha) {
        this.ultimaSenhaChamada = numeroFicha;
    }

    public int getUltimaSenhaChamada() {
        return ultimaSenhaChamada;
    }
}