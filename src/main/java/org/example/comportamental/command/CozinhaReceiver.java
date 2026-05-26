package org.example.comportamental.command;

public class CozinhaReceiver {
    private boolean chapaOcupada = false;
    private boolean fritadeiraOcupada = false;

    public void assarCarne() {
        this.chapaOcupada = true;
    }

    public void fritarBatata() {
        this.fritadeiraOcupada = true;
    }

    public boolean isChapaOcupada() {
        return chapaOcupada;
    }

    public boolean isFritadeiraOcupada() {
        return fritadeiraOcupada;
    }
}