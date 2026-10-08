package com.systembanking.entities;

public class ContaCorrente extends Conta {

    private Double limite = 1000.0;

    public ContaCorrente(Usuario usuario) {
        super(usuario);
    }

    public Double getSaldoDisponivel() {
        return getSaldo() + limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        } else if (valor > getSaldoDisponivel()) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        } else {
            super.sacar(valor);
        }
    }

    @Override
    public String imprimirInfoConta() {
        return super.imprimirInfoConta() +
                "Saldo disponível: R$ " + String.format("%.2f", getSaldoDisponivel());
    }
}
