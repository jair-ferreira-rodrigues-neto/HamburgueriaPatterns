package org.example.comportamental;

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