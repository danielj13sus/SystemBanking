package com.systembanking.entities;

public class ContaPoupanca extends Conta {

    private static final double TAXA_JUROS_PADRAO = 0.5;

    public ContaPoupanca(Usuario usuario) {
        super(usuario);
    }

    @Override
    public void renderJuros() {
        double juros = getSaldo() * TAXA_JUROS_PADRAO;
        depositar(juros);
    }

    @Override
    public String imprimirInfoConta() {
        return super.imprimirInfoConta() + "\n" +
                "Saldo: R$ " + String.format("%.2f", getSaldo());
    }
}
