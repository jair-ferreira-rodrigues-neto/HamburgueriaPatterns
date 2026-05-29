package org.example.criacional.prototype;

public class CupomSorteio implements Cloneable {
    private String regulamento;
    private String cpfCliente;

    public CupomSorteio(String regulamento) {
        this.regulamento = regulamento;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDetalhes() {
        return "Regras: " + regulamento + " | Participante: " + cpfCliente;
    }

    @Override
    public CupomSorteio clone() {
        try {
            return (CupomSorteio) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}