package org.example.comportamental.observer;

import org.example.comportamental.state.OrdemDePreparo;

import java.util.ArrayList;
import java.util.List;

public class PainelDeSenhas {
    private List<PedidoObserver> monitores = new ArrayList<>();

    public void registrarMonitor(PedidoObserver observador) {
        monitores.add(observador);
    }

    public void notificarMonitores(int numeroFicha) {
        for (PedidoObserver monitor : monitores) {
            monitor.atualizar(numeroFicha);
        }
    }

    public void chamarSenha(OrdemDePreparo ordem) {
        if (ordem.getStatus().equals("Aguardando retirada")) {
            notificarMonitores(ordem.getNumeroFicha());
        }
    }
}