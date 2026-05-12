package com.appmate.controller;

import com.appmate.security.JwtUtil;
import com.appmate.model.Usuario;
import com.appmate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    private final JwtUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Records para el Login
    public record LoginRequest(String username, String password) {}
    public record JwtResponse(String token) {}

    // Metodo de Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return usuarioService.BuscarPorEmail(request.username()) 
        .map(usuario -> {
            if(usuario.getPass().equals(request.password())){
                String token = jwtUtil.generateToken(usuario.getEmail());
                return ResponseEntity.ok(new JwtResponse(token));   
            }
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        })
        .orElse(ResponseEntity.status(401).body("Usuario No Encontrado"));
        }

    // Metodo Post para crear usuarios
    @PostMapping("/crear")
    public ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.GuardarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios() {
        try {
            // Asumiendo que en tu service tienes un método llamado obtenerTodos()
            return ResponseEntity.ok(usuarioService.obtenerTodos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener usuarios: " + e.getMessage());
        }
    }

}