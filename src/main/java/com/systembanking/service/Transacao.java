package com.systembanking.service;

import com.systembanking.Conta;
import com.systembanking.Conta;

public class Transacao {

    Conta contaOrigem;

    public Transacao(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void depositar(double valor) {
        contaOrigem.setSaldo(contaOrigem.getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. " +
                "\nNovo saldo: R$" + contaOrigem.getSaldo());
    }

    public void sacar(double valor) {
        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso. " +
                    "\nNovo saldo: R$" + contaOrigem.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}
