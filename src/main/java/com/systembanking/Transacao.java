package com.systembanking;

public class Transacao {

    Conta contaOrigem;

    public Transacao(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void depositar(double valor) {
        contaOrigem.saldo += valor;
    }

    public void sacar(double valor) {
        if (contaOrigem.saldo >= valor) {
            contaOrigem.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}
