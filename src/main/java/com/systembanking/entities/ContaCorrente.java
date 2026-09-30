package com.systembanking.entities;

public class ContaCorrente extends Conta {

    private static final Double LIMITE = 1000.0;

    public ContaCorrente(Usuario usuario) {
        super(usuario);
    }

}
