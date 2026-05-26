package org.example.comportamental.command;

import java.util.ArrayList;
import java.util.List;

public class ChefeInvoker {
    private List<CozinhaCommand> filaDeComandos = new ArrayList<>();

    public void adicionarComando(CozinhaCommand comando) {
        filaDeComandos.add(comando);
    }

    public void executarComandos() {
        for (CozinhaCommand comando : filaDeComandos) {
            comando.executar();
        }
        filaDeComandos.clear();
    }
}