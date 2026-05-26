package org.example.comportamental;

public class CanceladoState implements PedidoState {
    @Override
    public void avancar(OrdemDePreparo ordem) {
        throw new IllegalStateException("Pedido cancelado não avança.");
    }

    @Override
    public void cancelar(OrdemDePreparo ordem) {
        throw new IllegalStateException("Já está cancelado.");
    }

    @Override
    public String getStatus() {
        return "Cancelado e estornado";
    }
}