package org.example.comportamental.state;

public class OrdemDePreparo {
    private PedidoState estadoAtual;
    private int numeroFicha;

    public OrdemDePreparo(int numeroFicha) {
        this.numeroFicha = numeroFicha;
        this.estadoAtual = new EmPreparoState();
    }

    public void setEstado(PedidoState novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public void avancarEstado() {
        estadoAtual.avancar(this);
    }

    public void cancelarPedido() {
        estadoAtual.cancelar(this);
    }

    public String getStatus() {
        return estadoAtual.getStatus();
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }
}