package com.systembanking.entities;

import java.util.UUID;

public abstract class Conta {

    private String numeroConta;
    private Double saldo;
    private String agencia;
    private Usuario usuario;

    public Conta(String agencia, Usuario usuario) {
        this.numeroConta = UUID.randomUUID().toString().substring(0,8);
        this.agencia = agencia;
        this.usuario = usuario;
        this.saldo = 0.0;
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
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (agencia != null && !agencia.trim().isEmpty()) {
            this.agencia = agencia;
        } else {
            throw new IllegalArgumentException("Agência não pode ser nula ou vazia.");
        }
    }

    public Usuario getCliente() {
        return usuario;
    }
}
