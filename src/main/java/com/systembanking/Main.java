package com.systembanking;


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
        System.out.print("CPF: ");
        String cpf = input.nextLine();

        // Criar o usuário
        Usuario usuario = new Usuario(nome, email, telefone, cpf);





    }
}