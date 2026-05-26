package org.example.comportamental.state;

public interface PedidoState {
    void avancar(OrdemDePreparo ordem);

    void cancelar(OrdemDePreparo ordem);

    String getStatus();
}