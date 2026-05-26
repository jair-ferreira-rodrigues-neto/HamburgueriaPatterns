package org.example.comportamental;

public class FritarBatataCommand implements CozinhaCommand {
    private CozinhaReceiver cozinha;

    public FritarBatataCommand(CozinhaReceiver cozinha) {
        this.cozinha = cozinha;
    }

    @Override
    public void executar() {
        cozinha.fritarBatata();
    }
}