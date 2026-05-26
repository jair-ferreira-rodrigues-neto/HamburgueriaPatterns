package org.example.estrutural.bridge;

public class MercadoPagoProcessador implements ProcessadorBridge {
    @Override
    public boolean processarTransacao(double valor) {
        return true;
    }
}