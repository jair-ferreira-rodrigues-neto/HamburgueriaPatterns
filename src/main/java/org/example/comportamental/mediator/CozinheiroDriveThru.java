package org.example.comportamental.mediator;

public class CozinheiroDriveThru extends Funcionario {
    public CozinheiroDriveThru(DriveThruMediator mediator) {
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