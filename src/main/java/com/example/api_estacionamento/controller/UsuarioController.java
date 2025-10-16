package com.example.api_estacionamento.controller;

import com.example.api_estacionamento.model.Usuarios;
import com.example.api_estacionamento.dto.CadastroRequest;
import com.example.api_estacionamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody CadastroRequest cadastroRequest) {
        try {
            Usuarios novoUsuario = new Usuarios(cadastroRequest.getUsuario(), cadastroRequest.getSenha());
            usuarioService.cadastrar(novoUsuario, cadastroRequest.getConfirmaSenha());
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuarios usuario) {
        boolean autenticado = usuarioService.autenticar(usuario.getUsuario(), usuario.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos.");
        }
    }
}
