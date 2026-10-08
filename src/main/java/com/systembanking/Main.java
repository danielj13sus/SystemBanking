package com.systembanking;


import com.systembanking.entities.Conta;
import com.systembanking.entities.ContaCorrente;
import com.systembanking.entities.ContaPoupanca;
import com.systembanking.entities.Usuario;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Conta conta = null;

        // Obter os dados do usuário
        System.out.println("Cadastro de Usuário:");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("CPF (exemplo: XXX.XXX.XXX-XX): ");
        String cpf = input.nextLine();

        // Criar o usuário
        Usuario usuario = new Usuario(nome, email, telefone, cpf);
        System.out.println("----------------------\n" +
                "USUÁRIO CADASTRADO!\n" +
                usuario);

        System.out.print("Qual tipo de conta deseja criar? (1 - Conta Corrente, 2 - Conta Poupança): ");
        int tipoConta = input.nextInt();
        input.nextLine();

        // Criar a conta com base na escolha do usuário
        switch (tipoConta) {
            case 1 -> {
                conta = new ContaCorrente(usuario);
                System.out.println("Conta corrente criada com sucesso! Número da conta: " + conta.getNumeroConta());
            }
            case 2 -> {
                conta = new ContaPoupanca(usuario);
                System.out.println("Conta poupança criada com sucesso! Número da conta: " + conta.getNumeroConta());
                conta.renderJuros();
                System.out.println("Seu saldo já está rendendo juros!");
            }
            default -> System.out.println("Tipo de conta inválido.");
        }

        int validacao = 0;

        // Loop para realizar operações na conta
        do {
            System.out.println("Escolha uma operação:\n " +
                    "1 - Depositar\n " +
                    "2 - Sacar\n " +
                    "3 - Consultar Saldo\n ");
            int operacao = input.nextInt();

            switch (operacao) {
                case 1 -> {
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = input.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso! Novo saldo: " + conta.getSaldo());
                }
                case 2 -> {
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = input.nextDouble();
                    try {
                        conta.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso! Novo saldo: " + conta.getSaldo());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("--- SALDO ATUAL --- \n" +
                            conta.imprimirInfoConta());
                }
                default -> System.out.println("Operação inválida. Tente novamente.");
            }

            System.out.println("1 - Realizar outra operação\n" +
                    "2 - Sair");
            validacao = input.nextInt();

        } while (validacao == 1);

        input.close();

    }
}