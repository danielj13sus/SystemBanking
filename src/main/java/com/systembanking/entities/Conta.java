package com.systembanking.entities;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Conta {

    private String numeroConta;
    private Double saldo = 0.0;
    private static final String AGENCIA_PADRAO = "1234-5";
    private Usuario usuario;

    public Conta(Usuario usuario) {
        this.numeroConta = String.format("%08d", ThreadLocalRandom.current().nextInt(10000000));
        this.usuario = usuario;
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta != null && !numeroConta.trim().isEmpty()) {
            this.numeroConta = numeroConta;
        } else {
            throw new IllegalArgumentException("Número da conta não pode ser nulo ou vazio.");
        }
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
    }

    public void sacar(Double valor) {
        if (valor >= 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Valor do saque inválido ou saldo insuficiente.");
        }
    }

    public String getAgencia() {
        return AGENCIA_PADRAO;
    }

    public Usuario getCliente() {
        return usuario;
    }
}
