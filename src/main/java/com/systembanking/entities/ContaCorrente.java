package com.systembanking.entities;

public class ContaCorrente extends Conta {

    private Double limite = 1000.0;

    public ContaCorrente(Usuario usuario) {
        super(usuario);
    }

    public void usarCredito(double valor) {
        if (valor > 0 && valor <= limite) {
            this.limite -= valor;
        } else {
            throw new IllegalArgumentException("Valor do limite inválido.");
        }
    }

}
