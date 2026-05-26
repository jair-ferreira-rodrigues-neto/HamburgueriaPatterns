package org.example.comportamental;

public class CaixaDriveThru extends Funcionario {
    public CaixaDriveThru(DriveThruMediator mediator) {
        super(mediator);
    }

    @Override
    public void enviar(String mensagem) {
        mediator.enviarMensagem(mensagem, this);
    }

    @Override
    public void receber(String mensagem) {
        this.ultimaMensagem = mensagem;
    }
}