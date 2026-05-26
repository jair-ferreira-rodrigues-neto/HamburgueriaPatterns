package org.example.comportamental;

public abstract class Funcionario {
    protected DriveThruMediator mediator;
    protected String ultimaMensagem;

    public Funcionario(DriveThruMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void enviar(String mensagem);

    public abstract void receber(String mensagem);

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}