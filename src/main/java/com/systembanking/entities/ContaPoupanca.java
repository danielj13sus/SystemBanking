package com.systembanking.entities;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Usuario usuario) {
        super(usuario);
    }

    public void renderJuros(double taxa) {
        if (taxa > 0) {
            double juros = getSaldo() * (taxa / 100);
            depositar(juros);
        } else {
            throw new IllegalArgumentException("Taxa de juros deve ser positiva.");
        }
    }

}
