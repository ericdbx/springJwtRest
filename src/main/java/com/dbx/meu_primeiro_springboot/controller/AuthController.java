package com.dbx.meu_primeiro_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbx.meu_primeiro_springboot.model.Usuario;
import com.dbx.meu_primeiro_springboot.security.JwtUtil;
import com.dbx.meu_primeiro_springboot.service.UsuarioService;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register( @RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registraUsuario(request.get("username"), "password");
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<Usuario> usuario = usuarioService.buscaPorUsername(request.get("username"));
        if(usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
            String token = JwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
    
}
