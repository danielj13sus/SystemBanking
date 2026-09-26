package com.systembanking.entities;

public class ContaCorrente extends Conta {

    private static final Double LIMITE = 1000.0;

    public ContaCorrente(String numeroConta, String agencia, Usuario usuario) {
        super(numeroConta, agencia, usuario);
    }

}
