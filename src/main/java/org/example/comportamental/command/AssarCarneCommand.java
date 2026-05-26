package org.example.comportamental.command;

public class AssarCarneCommand implements CozinhaCommand {
    private CozinhaReceiver cozinha;

    public AssarCarneCommand(CozinhaReceiver cozinha) {
        this.cozinha = cozinha;
    }

    @Override
    public void executar() {
        cozinha.assarCarne();
    }
}