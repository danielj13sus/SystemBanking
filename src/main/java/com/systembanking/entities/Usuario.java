package com.systembanking.entities;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String cpf) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.trim().isEmpty() && cpf.matches("\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido. Deve estar no formato XXX.XXX.XXX-XX.");
        }
    }
}
