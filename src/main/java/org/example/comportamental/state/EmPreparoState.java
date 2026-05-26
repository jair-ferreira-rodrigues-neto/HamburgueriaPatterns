package org.example.comportamental;

public class EmPreparoState implements PedidoState {
    @Override
    public void avancar(OrdemDePreparo ordem) {
        ordem.setEstado(new ProntoState());
    }

    @Override
    public void cancelar(OrdemDePreparo ordem) {
        ordem.setEstado(new CanceladoState());
    }

    @Override
    public String getStatus() {
        return "Na chapa";
    }
}