package com.appmate.service;

import com.appmate.model.Usuario;
import com.appmate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired

    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> BuscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }


    public Usuario GuardarUsuario(Usuario usuario){
        // Logica de la app
        // Ejemplo
        if (usuario.getDni().isEmpty()){
            throw new RuntimeException ("Campo dni Vacio");
        }
        if (usuario.getNombre().isEmpty()){
            throw new RuntimeException ("Campo nombre Vacio");
        }
        if (usuario.getEmail().isEmpty()){
            throw new RuntimeException ("Campo email Vacio");
        }
        if (usuario.getPass().isEmpty()){
            throw new RuntimeException ("Campo contraseña Vacio");
        }

        if (!"PROFESOR".equals(usuario.getRol()) && !"ALUMNO".equals(usuario.getRol())) {
            throw new RuntimeException("Campo rol con datos invalidos");
        }
        return usuarioRepository.save(usuario);
    }

}
