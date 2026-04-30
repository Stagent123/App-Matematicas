package com.appmate.controller;

import com.appmate.model.Usuario;
import com.appmate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//url de la pagina
@RequestMapping("/api/Usuarios")
//CORS Cambiar el Puerto una vez se vaya a probar la app frontend
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired

    private UsuarioService usuarioService;

    //Metodo Post
    @PostMapping("/Crear")
    public  ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario){
        try{
            //Llamada al service 
            Usuario nuevoUsuario = usuarioService.GuardarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } 

    public record Login(
        String email
        String pass
    ){}

    public record Token(){
        String token    
    }

    @PostMapping("/Login")
    public Token login(@RequestBody Login login){
        if (!this.UsuarioRepository.existByEmail(login.email())){
            throw new Exception("Usuario No Encontrado")
        }
        User = user 
    }


}
 