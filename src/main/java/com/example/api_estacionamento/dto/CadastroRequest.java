package com.example.api_estacionamento.controller;

public class CadastroRequest {

    private String usuario;
    private String senha;
    private String confirmaSenha;

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getConfirmaSenha() { return confirmaSenha; }
    public void setConfirmaSenha(String confirmaSenha) { this.confirmaSenha = confirmaSenha; }
}