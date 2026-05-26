package org.example.estrutural;

public class MercadoPagoProcessador implements ProcessadorBridge {
    @Override
    public boolean processarTransacao(double valor) {
        return true;
    }
}