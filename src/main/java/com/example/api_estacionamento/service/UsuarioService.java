package com.example.api_estacionamento.service;

import com.example.api_estacionamento.model.Usuarios;
import com.example.api_estacionamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String usuario, String senha) {
        return usuarioRepository.findByUsuario(usuario)
                .map(u -> u.getSenha().equals(senha))
                .orElse(false);
    }

    public Usuarios cadastrar(Usuarios usuario, String confirmaSenha) {
        if (!usuario.getSenha().equals(confirmaSenha)) {
            throw new IllegalArgumentException("Senhas não coincidem!");
        }
        return usuarioRepository.save(usuario);
    }
}