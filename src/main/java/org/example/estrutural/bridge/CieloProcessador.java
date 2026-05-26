package org.example.estrutural.bridge;

public class CieloProcessador implements ProcessadorBridge {
    @Override
    public boolean processarTransacao(double valor) {
        return true;
    }
}