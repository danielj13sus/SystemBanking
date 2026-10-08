package com.systembanking.entities;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Conta {

    private String numeroConta;
    private Double saldo = 0.0;
    private static final String AGENCIA_PADRAO = "1234-5";
    private Usuario usuario;

    public Conta(Usuario usuario) {
        this.numeroConta = String.format("%08d", ThreadLocalRandom.current().nextInt(1, 10000000));
        this.usuario = usuario;
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor >= 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Valor do saque inválido ou saldo insuficiente.");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void renderJuros() {
        // TODO Método vazio, pode ser sobrescrito por subclasses
    }

    public String imprimirInfoConta() {
        return "Titular: " + usuario.getNome() + "\n" +
                "Email: " + usuario.getEmail() + "\n" +
                "Telefone: " + usuario.getTelefone() + "\n" +
                "CPF: " + usuario.getCpf() + "\n" +
                "Conta: " + getNumeroConta() + "\n" +
                "Agência: " + AGENCIA_PADRAO + "\n";
    }
}
