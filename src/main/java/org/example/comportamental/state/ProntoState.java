package org.example.comportamental.state;

public class ProntoState implements PedidoState {
    @Override
    public void avancar(OrdemDePreparo ordem) {
        throw new IllegalStateException("O pedido já está finalizado.");
    }

    @Override
    public void cancelar(OrdemDePreparo ordem) {
        throw new IllegalStateException("Tarde demais para cancelar, já está pronto.");
    }

    @Override
    public String getStatus() {
        return "Aguardando retirada";
    }
}