package org.example.estrutural;

public class CartaoPagamento extends Pagamento {
    public CartaoPagamento(ProcessadorBridge processador) {
        super(processador);
    }

    @Override
    public String realizarPagamento(double valor) {
        if (processador.processarTransacao(valor)) {
            return "Pago no cartão: " + valor;
        }
        return "Falha no cartão";
    }
}