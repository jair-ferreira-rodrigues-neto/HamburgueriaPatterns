package org.example.comportamental;

public interface PedidoState {
    void avancar(OrdemDePreparo ordem);

    void cancelar(OrdemDePreparo ordem);

    String getStatus();
}