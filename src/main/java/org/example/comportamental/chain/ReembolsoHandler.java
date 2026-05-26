package org.example.comportamental;

public abstract class ReembolsoHandler {
    protected ReembolsoHandler proximo;

    public void setProximo(ReembolsoHandler proximo) {
        this.proximo = proximo;
    }

    public abstract String processarReembolso(double valor);
}