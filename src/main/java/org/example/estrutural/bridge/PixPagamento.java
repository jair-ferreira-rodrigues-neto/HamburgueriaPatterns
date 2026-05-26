package org.example.estrutural;

public class PixPagamento extends Pagamento {
    public PixPagamento(ProcessadorBridge processador) {
        super(processador);
    }

    @Override
    public String realizarPagamento(double valor) {
        if (processador.processarTransacao(valor)) {
            return "Pago no PIX: " + valor;
        }
        return "Falha no PIX";
    }
}