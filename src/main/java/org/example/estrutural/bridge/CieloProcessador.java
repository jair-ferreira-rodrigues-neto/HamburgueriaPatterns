package org.example.estrutural;

public class CieloProcessador implements ProcessadorBridge {
    @Override
    public boolean processarTransacao(double valor) {
        return true;
    }
}