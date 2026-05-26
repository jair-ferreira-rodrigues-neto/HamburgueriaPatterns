package org.example.comportamental;

import java.util.ArrayList;
import java.util.List;

public class CoordenadorMediator implements DriveThruMediator {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void registrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void enviarMensagem(String mensagem, Funcionario remetente) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != remetente) {
                funcionario.receber(mensagem);
            }
        }
    }
}