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

        switch (tipoConta) {
            case 1 -> {
                Conta conta = new ContaCorrente(usuario);
                System.out.println("Conta corrente criada com sucesso! Número da conta: " + conta.getNumeroConta());
            }
            case 2 -> {
                Conta conta = new ContaPoupanca(usuario);
                System.out.println("Conta poupança criada com sucesso! Número da conta: " + conta.getNumeroConta());
            }
        }

//        do {
//
//        } while () // TODO: Implementar o menu de operações bancárias (depósito, saque, transferência, etc.))

        input.close();

    }
}